package com.example.lesson_6_migunova.banner

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.lesson_6_migunova.MainActivity
import com.example.lesson_6_migunova.R
import com.example.lesson_6_migunova.databinding.FragmentBannerPageBinding

class BannerPageFragment : Fragment(R.layout.fragment_banner_page) {

    private val binding by viewBinding(FragmentBannerPageBinding::bind)

    private var listener: OnItemClickListener? = null

    override fun onAttach(context: Context) {
        super.onAttach(context)
        listener = activity as? OnItemClickListener
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        arguments?.let {
            val image = it.getInt(ARG_IMAGE)
            val text = it.getString(ARG_TEXT)

            binding.imageView.setImageResource(image)
            binding.textView.text = text
        }

        binding.imageView.setOnClickListener {
            listener?.onItemClick(binding.textView.text.toString())
        }
    }

    companion object {
        private const val ARG_IMAGE = "image"
        private const val ARG_TEXT = "text"

        fun newInstance(image: Int, text: String) =
            BannerPageFragment().apply {
                arguments = Bundle().apply {
                    putInt(ARG_IMAGE, image)
                    putString(ARG_TEXT, text)
                }
            }
    }
}
