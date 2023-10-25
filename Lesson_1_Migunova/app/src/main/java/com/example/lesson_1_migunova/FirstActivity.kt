package com.example.lesson_1_migunova

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.lesson_1_migunova.databinding.ActivityFirstBinding
import java.util.TreeSet

class FirstActivity : AppCompatActivity() {

    private lateinit var binding : ActivityFirstBinding
    private val names = TreeSet<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityFirstBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val studentName = binding.editText

        // сохранение имени при нажатии на первую кнопку
        binding.button1.setOnClickListener {
            val name = studentName.text.toString()
            if (name == "") {
                Toast.makeText(this, "Введите имя", Toast.LENGTH_SHORT).show()
            }
            else {
                names.add(name)
            }
        }

        // вывод списка имен при нажатии на вторую кнопку
        binding.button2.setOnClickListener {
            binding.textView.text = ""

            names.forEach() {
                binding.textView.append("${it}\n")
            }
        }
    }
}