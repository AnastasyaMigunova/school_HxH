package com.example.lesson_7_migunova.presentation

import android.annotation.SuppressLint
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.lesson_7_migunova.OnItemClickListener
import com.example.lesson_7_migunova.R
import com.example.lesson_7_migunova.data.model.Bridge

class BridgeAdapter : RecyclerView.Adapter<BridgeViewHolder>() {
    private val bridges = mutableListOf<Bridge>()
    private var itemClickListener: OnItemClickListener? = null

    fun setOnItemClickListener(listener: OnItemClickListener?) {
        this.itemClickListener = listener
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BridgeViewHolder {
        return BridgeViewHolder(parent)
    }

    override fun getItemCount(): Int {
        return bridges.size
    }

    override fun onBindViewHolder(holder: BridgeViewHolder, position: Int) {
        holder.itemView.setOnClickListener {
            itemClickListener?.onItemClick(bridges[position])
        }

        holder.bind(bridges[position])
    }

    @SuppressLint("NotifyDataSetChanged")
    fun submitList(bridges: List<Bridge>) {
        this.bridges.clear()
        this.bridges.addAll(bridges)
        notifyDataSetChanged()
    }
}