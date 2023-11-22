package com.example.lesson_7_migunova.data.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class DivorceTime(
    val start: String?,
    val end: String?
) : Parcelable
