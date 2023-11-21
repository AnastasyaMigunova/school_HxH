package com.example.lesson_6_migunova.banner

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.lesson_6_migunova.R
import com.example.lesson_6_migunova.databinding.FragmentThirdBinding

class ThirdFragment : Fragment(R.layout.fragment_third) {

    private val binding by viewBinding(FragmentThirdBinding::bind)
    private val bannerFragment = BannerFragment.newInstance()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.buttonShowBanner.setOnClickListener {
            if (binding.buttonShowBanner.text == getString(R.string.show_banner)) {
                binding.buttonShowBanner.text = getString(R.string.hide_banner)

                childFragmentManager.beginTransaction()
                    .replace(R.id.fragment_banner, bannerFragment)
                    .addToBackStack(null)
                    .commit()
            }
            else {
                binding.buttonShowBanner.text = getString(R.string.show_banner)
                childFragmentManager.beginTransaction()
                    .remove(bannerFragment)
                    .commit()
            }
        }
    }

    companion object {
        fun newInstance() : ThirdFragment {
            return ThirdFragment()
        }
    }
}