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
import com.example.moviesapp.common.utils.Resource
import com.example.moviesapp.common.utils.setImage
import com.example.moviesapp.databinding.FragmentMovieDetailsBinding
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.PlayerConstants
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.YouTubePlayer
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.AbstractYouTubePlayerListener
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.utils.loadOrCueVideo
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
        loadTrailer(safeArgs.id)
//        setupYoutubePlayer()
    }

    private fun initListeners(){
        binding.backBtn.setOnClickListener {
            navigateToPopularMovies()
        }

        binding.showMoreTv.setOnClickListener {
            showMore()
        }

        binding.movieOverview.setOnClickListener {
            showLess()
        }

    }

    private fun setupUI(){
        observeMovieDetails()
        observerTrailer()
    }

    private fun navigateToPopularMovies(){
        findNavController().popBackStack()
    }

    private fun loadMovieDetails(){
        viewModel.loadMovieDetails(safeArgs.id)
    }

    private fun loadTrailer(movieId:Int){
        viewModel.getTrailer(movieId)
    }

    private fun observeMovieDetails(){
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

    private fun observerTrailer(){
        viewModel.trailer.observe(viewLifecycleOwner){ trailer ->
            when(trailer){
                is Resource.Success -> {
                    val list = trailer.data.results
                    for (i in list.indices){
                        if (list[i].type == TRAILER){
                            initYoutubePlayer(list[i].key)
                            break
                        }else if (i == list.lastIndex){
                            trailerNotAvailable()
                        }
                    }
                }
                is Resource.Error -> {
                    trailerNotAvailable()
                }
                else ->{
                    trailerNotAvailable()
                }
            }
        }
    }

    private fun initYoutubePlayer(youtubeId:String){
        lifecycle.addObserver(binding.youtubePlayer)
        binding.youtubePlayer.addYouTubePlayerListener(
            object: AbstractYouTubePlayerListener(){
                override fun onReady(youTubePlayer: YouTubePlayer) {
                    youTubePlayer.cueVideo(youtubeId,0f)
                }
            }
        )
    }

    private fun trailerNotAvailable(){
        binding.trailerMessage.isVisible = true
        binding.youtubePlayer.isVisible = false
    }

    private fun showMore(){
        binding.movieOverview.setLines(7)
        binding.showMoreTv.isVisible = false
    }

    private fun showLess(){
        val movieOverview = binding.movieOverview
        if (movieOverview.lineCount > 3){
            movieOverview.setLines(3)
            binding.showMoreTv.isVisible = true
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    companion object{
        private const val TRAILER = "Trailer"
        private const val MOVIE = "movie"
    }

}