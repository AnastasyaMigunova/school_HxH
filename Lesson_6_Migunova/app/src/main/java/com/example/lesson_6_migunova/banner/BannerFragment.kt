package com.example.lesson_6_migunova.banner

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.lesson_6_migunova.R
import com.example.lesson_6_migunova.databinding.FragmentBannerBinding

class BannerFragment : Fragment(R.layout.fragment_banner) {

    private val binding by viewBinding(FragmentBannerBinding::bind)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val pageAdapter = BannerPagerAdapter(this)
        binding.viewPager.adapter = pageAdapter

        binding.springDotsIndicator.setViewPager2(binding.viewPager)
    }

    companion object {
        fun newInstance() : BannerFragment {
            return BannerFragment()
        }
    }
}