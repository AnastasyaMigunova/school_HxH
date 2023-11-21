package com.example.lesson_6_migunova.data_classes

sealed class ListItem {
    data class WaterDetailsItem(val waterDetails: WaterDetails) : ListItem()

    data class EnergyDetailsItem(val energyDetails: EnergyDetails) : ListItem()
}
