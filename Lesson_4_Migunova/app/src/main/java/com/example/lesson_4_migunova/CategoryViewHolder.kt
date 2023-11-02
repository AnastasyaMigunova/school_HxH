package com.example.lesson_4_migunova

import android.annotation.SuppressLint
import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.lesson_4_migunova.databinding.ItemCategoryBinding

class CategoryViewHolder(
    parent: ViewGroup,
    private val categoryListener: CategoryListener,
) : RecyclerView.ViewHolder(
    LayoutInflater.from(parent.context).inflate(R.layout.item_category, parent, false),
) {
    private val binding by viewBinding(ItemCategoryBinding::bind)

    @SuppressLint("ResourceAsColor")
    fun bind(category: Category, position : Int) = with(binding) {
        root.setOnClickListener {
            categoryListener.onCategoryClick(category)
        }

        if (position == 0 || position == 1) {
            textViewDescription.setTextColor(Color.rgb(255, 66, 66))
        }

        imageViewIcon.setImageResource(category.image)
        textViewCategory.text = category.title
        textViewDescription.text = category.description
    }

    fun

}