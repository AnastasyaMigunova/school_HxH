package com.example.lesson_6_migunova

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.fragment.app.Fragment
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.lesson_6_migunova.banner.OnItemClickListener
import com.example.lesson_6_migunova.banner.ThirdFragment
import com.example.lesson_6_migunova.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), OnItemClickListener {

    private val binding by viewBinding(ActivityMainBinding::bind)
    private val firstItemFragment = FirstFragment.newInstance()
    private val secondItemFragment = SecondFragment.newInstance()
    private val thirdItemFragment = ThirdFragment.newInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setFragment(firstItemFragment)

        binding.bottomMenu.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.navigation_item_1 -> {
                    setFragment(firstItemFragment)
                    true}
                R.id.navigation_item_2 -> {
                    setFragment(secondItemFragment)
                    true
                }
                R.id.navigation_item_3 -> {
                    setFragment(thirdItemFragment)
                    true
                }
                else -> false
            }
        }
    }

    override fun onItemClick(text: String) {
        Toast.makeText(this, text, Toast.LENGTH_SHORT).show()
    }

            private fun setFragment(fragment : Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, fragment)
            .commit()
    }
}