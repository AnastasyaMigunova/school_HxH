package com.example.lesson_6_migunova

import com.example.lesson_6_migunova.data_classes.EnergyDetails
import com.example.lesson_6_migunova.data_classes.WaterDetails

interface InfoListener {
    fun onWaterInfoClick(waterDetails: WaterDetails)
    fun onEnergyInfoClick(energyDetails: EnergyDetails)
}