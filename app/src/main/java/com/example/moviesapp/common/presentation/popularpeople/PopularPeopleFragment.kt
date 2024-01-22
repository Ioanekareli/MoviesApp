package com.example.moviesapp.common.presentation.popularpeople

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.example.moviesapp.R
import com.example.moviesapp.common.utils.Resource
import com.example.moviesapp.databinding.FragmentPopularPeopleBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class PopularPeopleFragment : Fragment(R.layout.fragment_popular_people) {

    private val binding get() = _binding!!
    private var _binding:FragmentPopularPeopleBinding?=null

    private val vm:PopularPeopleViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentPopularPeopleBinding.inflate(layoutInflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initListeners()
        loadPopularPeople()
        setupUI()
    }

    private fun initListeners(){
        swipeRefresh()
    }

    private fun setupUI() {
        val adapter = createAdapter()
        initRecyclerView(adapter)
        observePopularPeople(adapter)
    }

    private fun swipeRefresh(){
        binding.swipeRefreshLayout.setOnRefreshListener {
            vm.swipeRefresh()
            binding.swipeRefreshLayout.isRefreshing = false
        }
    }

    private fun createAdapter():PopularPeopleRecyclerAdapter{
        return PopularPeopleRecyclerAdapter(::onClick)
    }

    private fun onClick(personId:Int){
        val bundle = bundleOf("id" to personId)
        findNavController().navigate(R.id.peopleDetailsFragment,bundle)
    }

    private fun initRecyclerView(
        popularPeopleRecyclerAdapter: PopularPeopleRecyclerAdapter
    ){
        binding.popularPeopleRecycler.apply {
            adapter = popularPeopleRecyclerAdapter
            layoutManager = GridLayoutManager(requireContext(),4)
        }
    }

    private fun observePopularPeople(adapter: PopularPeopleRecyclerAdapter){
        vm.popularPeople.observe(viewLifecycleOwner){ popularPeople ->
            when(popularPeople){
                is Resource.Success -> {
                    adapter.setData(popularPeople.data.popularPeopleDetails)
                    binding.shimmerLayout.stopShimmer()
                    binding.shimmerLayout.visibility = View.GONE
                }
                is Resource.Error -> {
                    binding.shimmerLayout.stopShimmer()
                    binding.shimmerLayout.visibility = View.GONE
                }
                is Resource.Loading -> {
                    binding.shimmerLayout.startShimmer()
                    binding.shimmerLayout.visibility = View.VISIBLE
                }
                else -> {}
            }
        }
    }

    private fun loadPopularPeople() {
        vm.loadPopularPeople()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}