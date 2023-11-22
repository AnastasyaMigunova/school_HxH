package com.example.lesson_7_migunova.data

import com.example.lesson_7_migunova.data.model.Bridge
import retrofit2.http.GET

interface MainApiService {
        @GET("bridges")
        suspend fun getBridges(): List<Bridge>
}