package com.example.lesson_2_migunova

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.lesson_2_migunova.databinding.ActivityFirstBinding

class FirstActivity : AppCompatActivity() {

    private lateinit var binding : ActivityFirstBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityFirstBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}