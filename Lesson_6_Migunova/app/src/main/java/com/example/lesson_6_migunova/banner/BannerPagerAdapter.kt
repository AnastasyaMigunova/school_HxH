package com.example.lesson_6_migunova.banner

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.lesson_6_migunova.R

class BannerPagerAdapter(fragment: Fragment) : FragmentStateAdapter(fragment) {

    private val pages = listOf(
        BannerPageFragment.newInstance(R.mipmap.first_cat, "Картинка 1"),
        BannerPageFragment.newInstance(R.mipmap.second_cat, "Картинка 2"),
        BannerPageFragment.newInstance(R.mipmap.third_cat, "Картинка 3")
    )

    override fun getItemCount(): Int = pages.size

    override fun createFragment(position: Int): Fragment {
        pages[position].setOnItemClickListener(object : OnItemClickListener {
            override fun onItemClick(text: String) {
                (pages[position].requireActivity() as? OnItemClickListener)?.onItemClick(text)
            }
        })
        return pages[position]
    }
}