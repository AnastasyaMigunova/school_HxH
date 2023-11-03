package com.example.lesson_4_migunova

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.lesson_4_migunova.databinding.ItemBaseInfoBinding
import com.example.lesson_4_migunova.databinding.ItemDetailInfoBinding

class BaseInfoViewHolder(
    parent: ViewGroup,
    private val infoListener: InfoListener,
) : RecyclerView.ViewHolder(
    LayoutInflater.from(parent.context).inflate(R.layout.item_base_info, parent, false),
) {
    private val baseBinding by viewBinding(ItemBaseInfoBinding::bind)
    private val detailBinding by viewBinding(ItemDetailInfoBinding::bind)

    fun bind(baseInfo: BaseInfo) = with(baseBinding) {
        root.setOnClickListener {
            infoListener.onBaseInfoClick(baseInfo)
        }

        imageViewIcon.setImageResource(baseInfo.image)
        textViewCategory.text = baseInfo.title
        textViewDescription.visibility = View.GONE
    }

    fun bind(detailInfo: DetailInfo) = with(detailBinding) {
        root.setOnClickListener {
            infoListener.onDetailInfoClick(detailInfo)
        }

        imageViewIcon.setImageResource(detailInfo.image)
        textViewCategory.text = detailInfo.title
        textViewDescription.text = detailInfo.description
    }
}