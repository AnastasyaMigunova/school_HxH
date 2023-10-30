package com.example.lesson_3_migunova

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.lesson_3_migunova.databinding.ActivityFirstBinding
import com.example.lesson_3_migunova.databinding.ActivityFirstBinding.*

class FirstActivity : AppCompatActivity() {

    private lateinit var binding : ActivityFirstBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = inflate(layoutInflater)

        setContentView(binding.root)

        fun bindProfile(profile: Profile) {
            binding.textViewPersonal.text = profile.personal_info

            binding.includeInfo.textViewTitle.text = profile.number_card
            binding.textViewPersonal.text = profile.personal_info

            binding.includeName.textView1.text = profile.name1
            binding.includeName.textView2.text = profile.name

            binding.includeSurname.textView1.text = profile.surname1
            binding.includeSurname.textView2.text = profile.surname

            binding.includeEmail.textView1.text = profile.email1
            binding.includeEmail.textView2.text = profile.email

            binding.includeLogin.textView1.text = profile.login1
            binding.includeLogin.textView2.text = profile.login

            binding.includeRegion.textView1.text = profile.region1
            binding.includeRegion.textView2.text = profile.region

        }

        bindProfile(Profile())

        binding.editButton.setOnClickListener {
            Toast.makeText(this, "Редактирование региона", Toast.LENGTH_SHORT).show()
        }

        binding.exitButton.setOnClickListener {
            Toast.makeText(this, "Выход из профиля", Toast.LENGTH_SHORT).show()
        }

        binding.toolbar.inflateMenu(R.menu.main_menu)

        val menuItem = binding.toolbar.menu.findItem(R.id.settings)
        menuItem.setOnMenuItemClickListener {
            Toast.makeText(this, "Редактирование профиля", Toast.LENGTH_SHORT).show()
            true
        }

        binding.toolbar.setNavigationOnClickListener {
            Toast.makeText(this, "Назад", Toast.LENGTH_SHORT).show()
        }
    }
}