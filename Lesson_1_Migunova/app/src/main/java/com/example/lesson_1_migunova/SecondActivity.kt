package com.example.lesson_1_migunova

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.KeyEvent
import android.widget.Toast
import com.example.lesson_1_migunova.databinding.ActivitySecondBinding

class SecondActivity : AppCompatActivity() {

    data class Student(
        val id: Long,
        val name: String,
        val surname: String,
        val grade: String,
        val birthdayYear: String
    )

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
                val (name, surname, grade, birthdayYear) = fields

                val studentData = Student(
                    id = System.currentTimeMillis(),
                    name = name,
                    surname = surname,
                    grade = grade,
                    birthdayYear = birthdayYear
                )
                studentsMap[studentData.id] = studentData

                Toast.makeText(this, data, Toast.LENGTH_SHORT).show()
                return@setOnKeyListener true
            }
            false
        }

        // вывод данных учеников при нажатии на кнопку
        binding.button.setOnClickListener {
            textOutput.text = ""

            for ((_, student) in studentsMap) {
                textOutput.append(
                    "${student.id} " +
                    "${student.name} " +
                    "${student.surname} " +
                    "${student.grade} " +
                    "${student.birthdayYear}\n"
                )
            }
        }
    }
}