package com.example.moviesapp.common.presentation.popularmovies

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.moviesapp.R
import com.example.moviesapp.common.domain.model.popularmovies.PopularMoviesDetails
import com.example.moviesapp.common.utils.Resource
import com.example.moviesapp.databinding.FragmentPopularMoviesBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class PopularMoviesFragment : Fragment() {

    private val binding get() = _binding!!
    private var _binding:FragmentPopularMoviesBinding?=null

    private val viewModel:PopularMoviesViewModel  by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentPopularMoviesBinding.inflate(layoutInflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupUI()
    }

    private fun setupUI(){
        val adapter = createAdapter()
        initRecyclerView(adapter)
        observeData(adapter)
    }

    private fun onClick(movieId:Int){
        val bundle = bundleOf("id" to movieId )
        findNavController().navigate(R.id.movieDetailsFragment,bundle)
    }

    private fun createAdapter():PopularMoviesRecyclerAdapter{
        return PopularMoviesRecyclerAdapter(::onClick)
    }

    private fun initRecyclerView(
        popularMoviesRecyclerAdapter: PopularMoviesRecyclerAdapter
    ){
        binding.popularMoviesRecycler.apply {
            adapter = popularMoviesRecyclerAdapter
            layoutManager = LinearLayoutManager(requireContext())
            setHasFixedSize(true)
        }
    }

    private fun observeData(adapter:PopularMoviesRecyclerAdapter){
        viewModel.popularMovies.observe(viewLifecycleOwner){
            when(it){
                is Resource.Success -> {
                    adapter.setData(it.data.results)
                    binding.progressBar.isVisible = false
                }
                is Resource.Error -> {
                    binding.progressBar.isVisible = false
                    binding.errorText.isVisible = true
                }
                is Resource.Loading -> {
                    binding.progressBar.isVisible = true
                }

                else -> {
                    binding.errorText.isVisible = true
                }
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}
