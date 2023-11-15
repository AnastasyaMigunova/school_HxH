package com.example.lesson_5_migunova

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.lesson_5_migunova.databinding.ActivityFirstBinding

class FirstActivity : AppCompatActivity() {

    private val binding by viewBinding(ActivityFirstBinding::bind)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_first)

        binding.buttonForFourth.setOnClickListener {
            startActivity(
                FourthActivity.createStartIntent(
                    this,
                    System.currentTimeMillis()
                )
            )
        }

        binding.buttonForSecond.setOnClickListener {
            val intent = Intent(this, SecondActivity::class.java)
            startActivity(intent)
        }
    }
}