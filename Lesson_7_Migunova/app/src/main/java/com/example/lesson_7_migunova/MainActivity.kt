package com.example.lesson_7_migunova

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.lesson_7_migunova.data.model.Bridge
import com.example.lesson_7_migunova.presentation.DetailsFragment
import com.example.lesson_7_migunova.presentation.MainFragment

class MainActivity : AppCompatActivity(), OnItemClickListener {

    private val mainFragment = MainFragment.newInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container_bridges, mainFragment)
            .commit()
    }

    override fun onItemClick(bridge: Bridge) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container_bridges, DetailsFragment.newInstance(bridge))
            .addToBackStack(null)
            .commit()
    }
}