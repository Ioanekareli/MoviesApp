package com.example.moviesapp.common.presentation.peopledetails

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter

class PeopleDetailsFragmentStateAdapter(
    fragment:Fragment,
    private val fragmentList:List<Fragment>
):FragmentStateAdapter(fragment) {
    override fun getItemCount() = FRAGMENTS_COUNT

    override fun createFragment(position: Int): Fragment {
        return fragmentList[position]
    }

    companion object{
        const val FRAGMENTS_COUNT = 2
    }

}