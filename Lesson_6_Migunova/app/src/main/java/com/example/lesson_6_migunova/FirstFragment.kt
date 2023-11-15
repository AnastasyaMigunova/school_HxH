package com.example.lesson_6_migunova

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import android.widget.Toast
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.lesson_6_migunova.databinding.FragmentFirstBinding

class FirstFragment : Fragment(R.layout.fragment_first) {

    private val binding by viewBinding(FragmentFirstBinding::bind)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.toolbar.menu.findItem(R.id.find_item).setOnMenuItemClickListener {
            Toast.makeText(activity, "Найти позицию", Toast.LENGTH_SHORT).show()
            true
        }
    }

    companion object {
        fun newInstance() : FirstFragment {
            return FirstFragment()
        }
    }
}