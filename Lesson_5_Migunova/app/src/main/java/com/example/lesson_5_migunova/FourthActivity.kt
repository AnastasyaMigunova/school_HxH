package com.example.lesson_5_migunova

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.lesson_5_migunova.databinding.ActivityFourthBinding
import java.text.SimpleDateFormat
import java.util.*

class FourthActivity : AppCompatActivity() {

    private val binding by viewBinding(ActivityFourthBinding::bind)

    private val timeValue by lazy { intent.getLongExtra(KEY_TIME_VALUE, 0) }
    private lateinit var dateFormat : SimpleDateFormat

    @SuppressLint("SimpleDateFormat")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fourth)

        dateFormat = SimpleDateFormat("yyyy.MM.dd HH:mm:ss")
        val formattedTime = dateFormat.format(timeValue)

        binding.textViewTime.text = formattedTime

        binding.buttonFourthAgain.setOnClickListener {
            val intent = createStartIntent(this, System.currentTimeMillis())
            intent.flags = Intent.FLAG_ACTIVITY_SINGLE_TOP
            startActivity(intent)
        }
    }

    override fun onNewIntent(intent: Intent?) {
        super.onNewIntent(intent)

        if (intent?.hasExtra(KEY_TIME_VALUE) == true) {
            val newTimeValue = intent.getLongExtra(KEY_TIME_VALUE, 0)
            binding.textViewTime.text = dateFormat.format(newTimeValue)
        }
    }

    companion object {
        private const val KEY_TIME_VALUE = "key_time_value"

        fun createStartIntent(context: Context, value: Long): Intent {
            return Intent(context, FourthActivity::class.java).apply {
                putExtra(KEY_TIME_VALUE, value)
            }
        }
    }
}