package com.example.lesson_7_migunova.data.model

import com.google.gson.annotations.SerializedName
import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
class Bridge (
    @SerializedName("name") val name: String?,
    @SerializedName("name_eng") val nameEng: String?,
    @SerializedName("description") val description: String?,
    @SerializedName("description_eng") val descriptionEng: String?,
    @SerializedName("divorces") val divorces: List<DivorceTime>,
    @SerializedName("photo_close_url") val photoCloseUrl : String?,
    @SerializedName("photo_open_url") val photoOpenUrl : String?,
    @SerializedName("public") val public : String?,
    var status : String,
    ) : Parcelable