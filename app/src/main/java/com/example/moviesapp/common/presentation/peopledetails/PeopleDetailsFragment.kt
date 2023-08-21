package com.example.moviesapp.common.presentation.peopledetails

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.moviesapp.R
import com.example.moviesapp.common.presentation.peopledetails.bio.PersonBiographyFragment
import com.example.moviesapp.common.presentation.peopledetails.movies.PersonMoviesFragment
import com.example.moviesapp.common.utils.Resource
import com.example.moviesapp.databinding.FragmentPeopleDetailsBinding
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class PeopleDetailsFragment : Fragment(R.layout.fragment_people_details) {

    private val binding get() = _binding!!
    private var _binding:FragmentPeopleDetailsBinding?=null

    private val vm:PeopleDetailsViewModel by viewModels()
    private val safeArgs:PeopleDetailsFragmentArgs by navArgs()

    private val fl = listOf(
        PersonBiographyFragment(),
        PersonMoviesFragment()
    )

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentPeopleDetailsBinding.inflate(layoutInflater,container,false)
        saveId(safeArgs.id)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUpUI()
        loadPersonDetails(safeArgs.id)
        initListeners()
    }

    private fun initListeners() {
        binding.personPageAppBar.backBtn.setOnClickListener {
            navigateBackStack()
        }
    }

    private fun setUpUI(){
        val adapter = createAdapter()
        initAdapter(adapter)
        observePersonName()
    }

    private fun initAdapter(
        stateAdapter: PeopleDetailsFragmentStateAdapter
    ) {
        val tabLayout:TabLayout = binding.personPageAppBar.tabLayout
        val pager = binding.personPageViewPager.apply {
            adapter = stateAdapter
        }
        TabLayoutMediator(tabLayout,pager){ tab,index ->
            tab.text = when(index){
                PERSON_BIO -> "Bio"
                PERSON_MOVIES -> "Movies"
                else -> EMPTY_STRING
            }
        }.attach()
    }

    private fun createAdapter():PeopleDetailsFragmentStateAdapter{
        return PeopleDetailsFragmentStateAdapter(this, fl)
    }

    private fun navigateBackStack() {
        findNavController().popBackStack()
    }

    private fun observePersonName(){
        vm.personDetails.observe(viewLifecycleOwner){personDetails ->
            when(personDetails) {
                is Resource.Success -> {
                    binding.personPageAppBar.personName.text = personDetails.data.name
                }
                else ->{

                }
            }
        }
    }

    private fun loadPersonDetails(personId:Int){
        vm.loadPersonDetails(personId)
    }

    private fun saveId(personId: Int){
        vm.saveId(personId)
    }

    companion object{
        private const val PERSON_BIO = 0
        private const val PERSON_MOVIES = 1
        private const val EMPTY_STRING = ""
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}