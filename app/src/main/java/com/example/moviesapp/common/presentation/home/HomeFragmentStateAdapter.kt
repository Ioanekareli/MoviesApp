package com.example.moviesapp.common.presentation.home

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import javax.inject.Inject

class HomeFragmentStateAdapter(
    fragment: Fragment,
    private val fragmentList:List<Fragment>
    ):FragmentStateAdapter(fragment) {

    override fun getItemCount() = FRAGMENTS_COUNT

    override fun createFragment(position: Int): Fragment {
        return fragmentList[position]
    }

    companion object{
        const val FRAGMENTS_COUNT = 1
    }
}