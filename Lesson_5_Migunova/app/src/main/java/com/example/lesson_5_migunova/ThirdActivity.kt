package com.example.lesson_5_migunova

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.result.contract.ActivityResultContracts
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.lesson_5_migunova.databinding.ActivityThirdBinding
import com.google.android.material.snackbar.Snackbar

class ThirdActivity : AppCompatActivity() {

    private val binding by viewBinding(ActivityThirdBinding::bind)

    private val launcher = registerForActivityResult(
        FifthActivityContract()
    ) { query ->
        Log.d("SNACKBAR", "SUCCESSFUL")
        Snackbar.make(binding.root, query, Snackbar.LENGTH_SHORT).show()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_third)


        binding.buttonForFirst.setOnClickListener {
            val intent = Intent(this, FirstActivity::class.java)
            startActivity(intent)
        }

        binding.buttonForFifth.setOnClickListener {
            val intent = Intent(this, FifthActivity::class.java)
            launcher.launch(Unit)
        }
    }
}