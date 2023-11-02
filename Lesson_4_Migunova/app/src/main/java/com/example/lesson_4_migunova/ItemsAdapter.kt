package com.example.lesson_4_migunova

import android.annotation.SuppressLint
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

private const val TYPE_CATEGORY = 0
private const val TYPE_CATEGORY1 = 1

class ItemsAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private val items = mutableListOf<ListItem>()
    lateinit var categoryListener: CategoryListener

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when (viewType) {
            TYPE_CATEGORY -> CategoryViewHolder(parent, categoryListener)
            TYPE_CATEGORY1 -> Category1ViewHolder(parent, categoryListener)
            else -> error("ViewType not supported")
        }
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {
            is CategoryViewHolder -> {
                holder.bind((items[position] as ListItem.CategoryItem).category, position)
                holder.itemView.setOnClickListener {
                    categoryListener.onCategoryClick((items[position] as ListItem.CategoryItem).category)
                }
            }
            is Category1ViewHolder -> {
                holder.bind((items[position] as ListItem.Category1Item).category1, position)
                holder.itemView.setOnClickListener {
                    categoryListener.onCategory1Click((items[position] as ListItem.Category1Item).category1)
                }
            }
        }
    }

    override fun getItemViewType(position: Int): Int {
        return if (items[position] is ListItem.Category1Item) {
            TYPE_CATEGORY1
        } else {
            TYPE_CATEGORY
        }
    }

    fun getSpanSize(position: Int): Int {
        return when (getItemViewType(position)) {
            TYPE_CATEGORY -> 1
            TYPE_CATEGORY1 -> 2
            else -> -1
        }
    }

    @SuppressLint("NotifyDataSetChanged")
    fun setList(categories: List<ListItem>) {
        this.items.clear()
        this.items.addAll(categories)
    }
}
