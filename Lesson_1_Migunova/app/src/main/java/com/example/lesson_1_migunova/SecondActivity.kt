package com.example.lesson_1_migunova

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.KeyEvent
import android.widget.Toast
import com.example.lesson_1_migunova.databinding.ActivitySecondBinding

class SecondActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySecondBinding
    private val studentsMap = hashMapOf<Long, Student>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val studentName = binding.editText
        val textOutput = binding.textView

        studentName.setOnKeyListener { _, keyCode, keyEvent ->
            if (keyEvent.action == KeyEvent.ACTION_DOWN && keyCode == KeyEvent.KEYCODE_ENTER) {

                val data = studentName.text.toString()

                val fields = data.split(" ").toTypedArray()

                if (fields.size == 4) {
                    val (name, surname, grade, birthdayYear) = fields

                    val studentData = Student(
                        id = System.currentTimeMillis(),
                        name = name,
                        surname = surname,
                        grade = grade,
                        birthdayYear = birthdayYear
                    )

                    studentsMap[studentData.id] = studentData
                } else {
                    Toast.makeText(this, "Введите 4 значения!", Toast.LENGTH_SHORT).show()
                }

                Toast.makeText(this, data, Toast.LENGTH_SHORT).show()
                return@setOnKeyListener true
            }
            false
        }

        // вывод данных учеников при нажатии на кнопку
        binding.button.setOnClickListener {
            textOutput.text = ""

            studentsMap.forEach { (_, value) ->
                textOutput.append(
                    "${value.id} ${value.name} ${value.surname} ${value.grade} ${value.birthdayYear}\n")
            }
        }
    }
}