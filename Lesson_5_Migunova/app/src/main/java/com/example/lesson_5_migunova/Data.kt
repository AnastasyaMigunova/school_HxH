package com.example.lesson_5_migunova

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
class Data (
    val value: String
) : Parcelable { }