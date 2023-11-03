package com.example.lesson_4_migunova

import android.annotation.SuppressLint
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

private const val TYPE_DETAIL = 0
private const val TYPE_BASE = 1

class ItemsAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private val items = mutableListOf<ListItem>()
    lateinit var infoListener: InfoListener

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when (viewType) {
            TYPE_DETAIL -> DetailInfoViewHolder(parent, infoListener)
            TYPE_BASE -> BaseInfoViewHolder(parent, infoListener)
            else -> error("ViewType not supported")
        }
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {
            is DetailInfoViewHolder -> {
                holder.bind((items[position] as ListItem.DetailInfoItem).detailInfo, position)
                holder.itemView.setOnClickListener {
                    infoListener.onDetailInfoClick((items[position] as ListItem.DetailInfoItem).detailInfo)
                }
            }
            is BaseInfoViewHolder -> {
                if (items.getOrNull(position - 1) is ListItem.DetailInfoItem && position % 2 == 0) {
                    holder.bind((items[position] as ListItem.DetailInfoItem).detailInfo)
                    holder.itemView.setOnClickListener {
                        infoListener.onDetailInfoClick((items[position] as ListItem.DetailInfoItem).detailInfo)
                    }
                } else {
                    holder.bind((items[position] as ListItem.BaseInfoItem).baseInfo)
                    holder.itemView.setOnClickListener {
                        infoListener.onBaseInfoClick((items[position] as ListItem.BaseInfoItem).baseInfo)
                    }
                }
            }
        }
    }

    override fun getItemViewType(position: Int): Int {
        return if (items[position] is ListItem.DetailInfoItem) {
            if (items.getOrNull(position + 1) is ListItem.BaseInfoItem && position % 2 == 0) {
                TYPE_BASE
            } else
                TYPE_DETAIL
        } else {
            TYPE_BASE
        }
    }

    fun getSpanSize(position: Int): Int {
        return when (getItemViewType(position)) {
            TYPE_DETAIL -> 1
            TYPE_BASE -> 2
            else -> -1
        }
    }

    @SuppressLint("NotifyDataSetChanged")
    fun setList(infoItems: List<ListItem>) {
        this.items.clear()
        this.items.addAll(infoItems)
    }
}
