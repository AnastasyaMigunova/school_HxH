package com.example.lesson_6_migunova

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout.LayoutParams
import androidx.core.content.ContextCompat
import androidx.core.view.updateLayoutParams
import androidx.recyclerview.widget.RecyclerView
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.lesson_6_migunova.data_classes.EnergyDetails
import com.example.lesson_6_migunova.data_classes.WaterDetails
import com.example.lesson_6_migunova.databinding.ItemDetailBinding


class DetailsViewHolder(
    parent: ViewGroup,
    private val context: Context,
    private val infoListener: InfoListener,
) : RecyclerView.ViewHolder(
    LayoutInflater.from(parent.context).inflate(R.layout.item_detail, parent, false),
) {
    private val binding by viewBinding(ItemDetailBinding::bind)

    fun bind(waterDetails: WaterDetails) = with(binding) {
        root.setOnClickListener {
            infoListener.onWaterInfoClick(waterDetails)
        }

        textMonth.textView.visibility = View.GONE
        textMonth.editText.visibility = View.GONE

        textPick.textView.visibility = View.GONE
        textPick.editText.visibility = View.GONE

        editTextDay.updateLayoutParams {
            this.width = LayoutParams.MATCH_PARENT
        }

        mainIcon.setImageResource(waterDetails.image)
        mainTitle.text= waterDetails.itemName
        barcode.setImageResource(waterDetails.barcode)
        serialNumber.text = waterDetails.serialNumber
        info.setImageResource(waterDetails.info)
        threeDotsInfo.setImageResource(waterDetails.threeDotsInfo)

        textViewDay.text = waterDetails.newIndications

        icAlert.setImageResource(waterDetails.iconAlert)
        textAlert.text = waterDetails.textAlert

    }

    fun bind(energyDetails: EnergyDetails) = with(binding) {
        root.setOnClickListener {
            infoListener.onEnergyInfoClick(energyDetails)
        }

        textMonth.textView.visibility = View.VISIBLE
        textMonth.editText.visibility = View.VISIBLE

        textPick.textView.visibility = View.VISIBLE
        textPick.editText.visibility = View.VISIBLE

        mainIcon.setImageResource(energyDetails.image)
        mainTitle.text= energyDetails.itemName
        barcode.setImageResource(energyDetails.barcode)
        serialNumber.text = energyDetails.serialNumber
        info.setImageResource(energyDetails.info)
        threeDotsInfo.setImageResource(energyDetails.threeDotsInfo)

        textAlert.text = energyDetails.textAlert
        textAlert.setTextColor(ContextCompat.getColor(context, R.color.black))

        editTextDay.updateLayoutParams {
            this.width = context.resources.getDimension(R.dimen.margin).toInt()
        }

        textViewDay.text = energyDetails.day

        textMonth.textView.text = energyDetails.month
        textPick.textView.text = energyDetails.pick

    }

}