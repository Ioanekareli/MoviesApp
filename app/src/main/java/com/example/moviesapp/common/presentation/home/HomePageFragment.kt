package com.example.moviesapp.common.presentation.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewpager2.widget.ViewPager2
import com.example.moviesapp.common.presentation.popularmovies.PopularMoviesFragment
import com.example.moviesapp.databinding.FragmentHomePageBinding
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class HomePageFragment : Fragment() {

    private val binding get() = _binding!!
    private var _binding:FragmentHomePageBinding? = null

    private val fragmentList = listOf(PopularMoviesFragment())

    private lateinit var tabLayout:TabLayout
    private lateinit var viewPager:ViewPager2

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomePageBinding.inflate(layoutInflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupUI()
    }

    private fun setupUI(){
        initAdapter()
    }

    private fun initAdapter(){
        tabLayout = binding.homePageAppBar.tabLayout
        viewPager = binding.viewPager
        viewPager.adapter = HomeFragmentStateAdapter(this,fragmentList)
        TabLayoutMediator(tabLayout,viewPager){ tab,index ->
            tab.text = when(index){
                POPULAR_MOVIES -> "Popular Movies"
                else -> EMPTY_STRING
            }
        }.attach()
    }

    companion object{
        private const val POPULAR_MOVIES = 0
        private const val EMPTY_STRING = ""
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}