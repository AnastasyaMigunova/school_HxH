package com.example.lesson_4_migunova

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.lesson_4_migunova.databinding.ItemDetailInfoBinding

class DetailInfoViewHolder(
    parent: ViewGroup,
    private val infoListener: InfoListener,
) : RecyclerView.ViewHolder(
    LayoutInflater.from(parent.context).inflate(R.layout.item_detail_info, parent, false),
) {
    private val binding by viewBinding(ItemDetailInfoBinding::bind)

    @SuppressLint("ResourceAsColor")
    fun bind(detailInfo: DetailInfo, position : Int) = with(binding) {
        root.setOnClickListener {
            infoListener.onDetailInfoClick(detailInfo)
        }

        if (position == 0 || position == 1) {
            textViewDescription.setTextColor(ContextCompat.getColor(root.context, R.color.red))
        }
        else {
            textViewDescription.setTextColor(ContextCompat.getColor(root.context, R.color.other_gray))
        }

        imageViewIcon.setImageResource(detailInfo.image)
        textViewCategory.text = detailInfo.title
        textViewDescription.text = detailInfo.description
    }

}