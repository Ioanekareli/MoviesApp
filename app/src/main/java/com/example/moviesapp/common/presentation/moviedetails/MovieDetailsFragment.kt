package com.example.moviesapp.common.presentation.moviedetails

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.moviesapp.R
import com.example.moviesapp.common.data.api.ApiConstants
import com.example.moviesapp.common.presentation.popularmovies.PopularMoviesViewModel
import com.example.moviesapp.common.utils.Resource
import com.example.moviesapp.common.utils.setImage
import com.example.moviesapp.databinding.FragmentMovieDetailsBinding
import com.example.moviesapp.databinding.FragmentPopularMoviesBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MovieDetailsFragment : Fragment(R.layout.fragment_movie_details){

    private val binding get() = _binding!!
    private var _binding: FragmentMovieDetailsBinding?=null

    private val viewModel: MovieDetailsViewModel by viewModels()
    private val safeArgs:MovieDetailsFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMovieDetailsBinding.inflate(layoutInflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initListeners()
        setupUI()
        loadMovieDetails()
    }

    private fun setupUI(){
        observeData()
    }

    private fun initListeners(){
        binding.backBtn.setOnClickListener {
            navigateToPopularMovies()
        }
    }

    private fun navigateToPopularMovies(){
        findNavController().popBackStack()
    }

    private fun loadMovieDetails(){
        viewModel.loadMovieDetails(safeArgs.id)
    }

    private fun observeData(){
        viewModel.movieDetails.observe(viewLifecycleOwner){ movieDetails ->
            when(movieDetails){
                is Resource.Success -> {
                    binding.progressBar.isVisible = false
                    with(binding){
                        moviePosterSmall.setImage(ApiConstants.IMG_URL + movieDetails.data.posterPath)
                        moviesPosterLarge.setImage(ApiConstants.IMG_URL + movieDetails.data.backdropPath)
                        movieTitle.text = movieDetails.data.title
                        runtime.text = movieDetails.data.runtime.toString()
                        budget.text = movieDetails.data.revenue.toString()
                        movieOverview.text = movieDetails.data.overview
                    }
                }
                is Resource.Error -> {
                    binding.progressBar.isVisible = false
                    binding.errorText.isVisible = true
                }
                is Resource.Loading -> {
                    binding.progressBar.isVisible = true
                }

                else -> {

                }
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}