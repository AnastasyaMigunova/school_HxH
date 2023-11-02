package com.example.lesson_4_migunova

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.lesson_4_migunova.databinding.ItemCategory1Binding

class Category1ViewHolder(
    parent: ViewGroup,
    private val categoryListener: CategoryListener,
) : RecyclerView.ViewHolder(
    LayoutInflater.from(parent.context).inflate(R.layout.item_category1, parent, false),
) {
    private val binding by viewBinding(ItemCategory1Binding::bind)

    fun bind(category1: Category1, position : Int) = with(binding) {
        root.setOnClickListener {
            categoryListener.onCategory1Click(category1)
        }

        if(position == 6) {
            textViewDescription.visibility = View.VISIBLE
        }

        imageViewIcon.setImageResource(category1.image)
        textViewCategory.text = category1.title
        textViewDescription.text = category1.description

    }
}