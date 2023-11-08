package com.example.lesson_3_migunova

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.example.lesson_3_migunova.databinding.ActivitySecondBinding

class SecondActivity : AppCompatActivity() {

    private lateinit var binding : ActivitySecondBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivitySecondBinding.inflate(layoutInflater)

        setContentView(binding.root)

        val profile = Profile()
        bindProfile(profile)

        binding.includeRegion.editButton.visibility = View.VISIBLE

        binding.includeRegion.editButton.setOnClickListener {
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

    private fun bindProfile(profile: Profile) {
        binding.includeInfo.textViewTitle.text = profile.numberCard
        binding.includeName.textView1.text = getString(R.string.name)
        binding.includeName.textView2.text = profile.name
        binding.includeSurname.textView1.text = getString(R.string.surname)
        binding.includeSurname.textView2.text = profile.surname
        binding.includeEmail.textView1.text = getString(R.string.email)
        binding.includeEmail.textView2.text = profile.email
        binding.includeLogin.textView1.text = getString(R.string.login)
        binding.includeLogin.textView2.text = profile.login
        binding.includeRegion.textView1.text = getString(R.string.region)
        binding.includeRegion.textView2.text = profile.region
    }
}