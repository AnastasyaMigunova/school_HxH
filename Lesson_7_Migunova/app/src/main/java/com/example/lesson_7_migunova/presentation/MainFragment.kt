package com.example.lesson_7_migunova.presentation

import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.View
import android.view.WindowManager
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.view.isVisible
import androidx.lifecycle.lifecycleScope
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.lesson_7_migunova.OnItemClickListener
import com.example.lesson_7_migunova.R
import com.example.lesson_7_migunova.data.ApiClient
import com.example.lesson_7_migunova.databinding.FragmentMainBinding
import kotlinx.coroutines.*
import kotlin.system.measureTimeMillis

class MainFragment : Fragment(R.layout.fragment_main) {

    private val binding by viewBinding(FragmentMainBinding::bind)
    private val bridgeAdapter = BridgeAdapter()

    private var listener: OnItemClickListener? = null

    override fun onAttach(context: Context) {
        super.onAttach(context)
        listener = activity as? OnItemClickListener
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val actionBar = (activity as? AppCompatActivity)?.supportActionBar

        actionBar?.let {
            it.setDisplayHomeAsUpEnabled(false)
            it.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
            it.setDisplayShowTitleEnabled(false)
        }

        binding.recyclerView.adapter = bridgeAdapter
        loadBridges()

        binding.toolbar.menu.findItem(R.id.item_info).setOnMenuItemClickListener {
            Toast.makeText(activity, "Информация", Toast.LENGTH_SHORT).show()
            true
        }

        binding.toolbar.menu.findItem(R.id.item_map).setOnMenuItemClickListener {
            Toast.makeText(activity, "Карта", Toast.LENGTH_SHORT).show()
            true
        }

        bridgeAdapter.setOnItemClickListener(listener)
    }

    private fun loadBridges() {
        lifecycleScope.launch {
            binding.progressBar.isVisible = true

            try {
                val bridges = ApiClient.apiService.getBridges()
                bridgeAdapter.submitList(bridges)
            } catch (e: Exception) {
                Log.e("ApiService", "Error fetching data: ${e.message}")
            }

            binding.progressBar.isVisible = false
        }
    }

    companion object {
        fun newInstance(): MainFragment {
            return MainFragment()
        }
    }

}