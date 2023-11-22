package com.example.lesson_7_migunova.presentation

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.lesson_7_migunova.R
import com.example.lesson_7_migunova.data.model.Bridge
import com.example.lesson_7_migunova.databinding.ItemBridgeBinding
import java.time.Duration
import java.time.LocalTime
import java.time.format.DateTimeFormatter

@SuppressLint("InflateParams")
class BridgeViewHolder(
    parent: ViewGroup,
) : RecyclerView.ViewHolder(
    LayoutInflater.from(parent.context).inflate(R.layout.item_bridge, null, false)
) {
    private val binding by viewBinding(ItemBridgeBinding::bind)

    fun bind(bridge: Bridge) {

        val stringBuilder = StringBuilder()
        var imageResource = R.drawable.ic_brige_normal
        bridge.status = "down"

        for (divorceTime in bridge.divorces) {
            stringBuilder.append("${divorceTime.start} - ${divorceTime.end}  ")

            val (startTime, endTime, currentTime) = convertedTime(divorceTime.start, divorceTime.end)

            val currentToFirstTime = Duration.between(currentTime, startTime).toMinutes()

            if (currentTime in startTime..endTime) {
                imageResource = R.drawable.ic_brige_late
                bridge.status = "raised"

            } else
                if (currentTime < startTime && currentToFirstTime < 60L) {
                    imageResource = R.drawable.ic_brige_soon
                    bridge.status = "soon_raised"
                }
            binding.imageViewBridge.setImageResource(imageResource)
        }

        when (bridge.name) {
            null -> binding.textViewTitle.text = "Пустые данные"
            else -> binding.textViewTitle.text = bridge.name
        }
        binding.textViewDivorces.text = stringBuilder.toString()
    }

    private fun convertedTime(firstTime: String?, secondTime: String?): List<LocalTime> {
        val pattern = DateTimeFormatter.ofPattern("H:mm")

        val convertedFirstTime = LocalTime.parse(firstTime, pattern)
        val convertedSecondTime = LocalTime.parse(secondTime, pattern)
        val currentTime =
            LocalTime.parse(LocalTime.now().format(DateTimeFormatter.ofPattern("HH:mm")))
        return listOf(convertedFirstTime, convertedSecondTime, currentTime)
    }
}