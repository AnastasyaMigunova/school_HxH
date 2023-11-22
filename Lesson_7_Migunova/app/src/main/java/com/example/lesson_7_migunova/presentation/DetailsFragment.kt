package com.example.lesson_7_migunova.presentation

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import by.kirich1409.viewbindingdelegate.viewBinding
import com.bumptech.glide.Glide
import com.example.lesson_7_migunova.R
import com.example.lesson_7_migunova.data.model.Bridge
import com.example.lesson_7_migunova.databinding.FragmentDetailsBinding
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch


class DetailsFragment : Fragment(R.layout.fragment_details) {

    private val binding by viewBinding(FragmentDetailsBinding::bind)
    private var bridge: Bridge? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val actionBar = (activity as? AppCompatActivity)?.supportActionBar

        actionBar?.let {
            it.setDisplayHomeAsUpEnabled(true)
            it.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
            it.setDisplayShowTitleEnabled(false)
        }

        arguments?.let {
            bridge = it.getParcelable(BRIDGE_KEY)
        }

        bridge?.let {
            binding.textViewTitleDetails.text = it.name
            binding.textViewDescriptionDetails.text = it.description

            val stringBuilder = StringBuilder()

            for (divorceTime in it.divorces) {
                stringBuilder.append("${divorceTime.start} - ${divorceTime.end}  ")
            }
            binding.textViewDivorcesDetails.text = stringBuilder.toString()

            loadDetails(it)
        }
    }

    private fun loadDetails(it : Bridge) {
        var imageIdentifier = R.drawable.ic_brige_normal

        lifecycleScope.launch {

            val imageUrl = when (it.status) {
                "raised" -> {
                    imageIdentifier = R.drawable.ic_brige_late
                    it.photoOpenUrl
                }
                "down" -> {
                    imageIdentifier = R.drawable.ic_brige_normal
                    it.photoCloseUrl
                }
                "soon_raised" -> {
                    imageIdentifier = R.drawable.ic_brige_soon
                    it.photoCloseUrl
                }
                else -> {
                    it.photoCloseUrl
                }
            }

            binding.progressBar.isVisible = true

            binding.imageViewBridgeDetails.setImageResource(imageIdentifier)
            Glide.with(this@DetailsFragment).load(imageUrl).into(binding.mainImage)

            binding.progressBar.isVisible = false
        }
    }

    companion object {

        private const val BRIDGE_KEY = "bridge"

        fun newInstance(bridge: Bridge) =
            DetailsFragment().apply {
                arguments = Bundle().apply {
                    putParcelable(BRIDGE_KEY, bridge)
                }
            }
    }
}