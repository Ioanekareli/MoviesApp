package com.example.moviesapp.common.presentation.home

import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.NavHostFragment
import androidx.viewpager2.widget.ViewPager2
import com.example.moviesapp.R
import com.example.moviesapp.common.presentation.popularmovies.PopularMoviesFragment
import com.example.moviesapp.common.presentation.popularpeople.PopularPeopleFragment
import com.example.moviesapp.common.presentation.toprated.TopRatedMoviesFragment
import com.example.moviesapp.common.presentation.tvseries.TopRatedSeriesFragment
import com.example.moviesapp.databinding.FragmentHomePageBinding
import com.google.android.material.navigation.NavigationView
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class HomePageFragment : Fragment() {

    private val binding get() = _binding!!
    private var _binding:FragmentHomePageBinding? = null

    private val fragmentList = listOf(
        PopularMoviesFragment(),
        PopularPeopleFragment(),
        TopRatedMoviesFragment(),
        TopRatedSeriesFragment()
    )

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
        initListeners()
    }

    private fun initListeners(){
        binding.homePageAppBar.backButton.setOnClickListener {
            openDrawer()
        }
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
                POPULAR_MOVIES -> "Popular"
                POPULAR_PEOPLE -> "People"
                TOP_RATED_MOVIES -> "Top Rated"
                TOP_RATED_SERIES -> "Series"
                else -> EMPTY_STRING
            }
        }.attach()
    }

    private fun openDrawer(){
        val drawerLayout = requireActivity().findViewById<DrawerLayout>(R.id.drawerLayout)
        val navigationView = requireActivity().findViewById<NavigationView>(R.id.drawer_menu)
        val navHostFragment = requireActivity().supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        val navController = navHostFragment.navController

        navigationView.setNavigationItemSelectedListener { menuItem ->
            when (menuItem.itemId) {
                R.id.menu_item_popular_movies -> {
                    drawerLayout.closeDrawer(GravityCompat.START)
                    true
                }
                R.id.menu_item_profile -> {
                    drawerLayout.closeDrawer(GravityCompat.START)
                    true
                }
                R.id.menu_item_search -> {
                    true
                }
                R.id.menu_item_my_movies -> {
                    navController.navigate(R.id.myMoviesFragment)
                    drawerLayout.closeDrawer(GravityCompat.START)
                    true
                }
                else -> {
                    false
                }
            }
        }
        drawerLayout.openDrawer(GravityCompat.START)
    }

    companion object{
        private const val POPULAR_MOVIES = 0
        private const val POPULAR_PEOPLE = 1
        private const val TOP_RATED_MOVIES = 2
        private const val TOP_RATED_SERIES = 3
        private const val EMPTY_STRING = ""
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}