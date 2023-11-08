package com.example.lesson_3_migunova

import androidx.viewbinding.ViewBinding
import com.example.lesson_3_migunova.databinding.ActivityFirstBinding
import com.example.lesson_3_migunova.databinding.ActivitySecondBinding

data class Profile(
    val numberCard: String = "Карта №7898769\nСпециалист",
    val name: String = "Анастасия",
    val surname: String = "Антонина",
    val email: String = "anykee.box@gmail.ru",
    val login: String = "HIE023UOI88",
    val region: String = "Санкт-Петербург"
)

