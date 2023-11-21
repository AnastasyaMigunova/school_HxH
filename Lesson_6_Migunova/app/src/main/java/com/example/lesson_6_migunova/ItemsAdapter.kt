package com.example.lesson_6_migunova

import android.annotation.SuppressLint
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.lesson_6_migunova.data_classes.ListItem

class ItemsAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private val items = mutableListOf<ListItem>()
    lateinit var infoListener: InfoListener

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
       return DetailsViewHolder(parent, parent.context, infoListener)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {
            is DetailsViewHolder -> {
                if (position == 2) {
                    holder.bind((items[position] as ListItem.EnergyDetailsItem).energyDetails)
                    holder.itemView.setOnClickListener {
                        infoListener.onEnergyInfoClick((items[position] as ListItem.EnergyDetailsItem).energyDetails)
                    }
                } else {
                    holder.bind((items[position] as ListItem.WaterDetailsItem).waterDetails)
                    holder.itemView.setOnClickListener {
                        infoListener.onWaterInfoClick((items[position] as ListItem.WaterDetailsItem).waterDetails)
                    }
                }
            }
        }
    }

    @SuppressLint("NotifyDataSetChanged")
    fun setList(infoItems: List<ListItem>) {
        this.items.clear()
        this.items.addAll(infoItems)
    }
}
