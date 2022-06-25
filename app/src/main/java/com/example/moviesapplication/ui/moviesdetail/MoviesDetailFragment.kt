package com.example.moviesapplication.ui.moviesdetail

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.navArgs
import com.example.moviesapplication.MoviesDetailViewModelProvider
import com.example.moviesapplication.MoviesViewModelProvider
import com.example.moviesapplication.R
import com.example.moviesapplication.databinding.FragmentMoviesDetailBinding
import com.example.moviesapplication.dto.Result
import com.example.moviesapplication.repository.MoviesRepository
import com.example.moviesapplication.ui.movieslist.MoviesListViewModel
import com.example.moviesapplication.utils.Resource
import com.example.moviesapplication.utils.setImage
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.YouTubePlayer
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.AbstractYouTubePlayerListener


class MoviesDetailFragment : Fragment(R.layout.fragment_movies_detail) {

    private val safeArgs:MoviesDetailFragmentArgs by navArgs()
    private lateinit var binding: FragmentMoviesDetailBinding
    private lateinit var movieDetailsViewModel:MovieDetailViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMoviesDetailBinding.inflate(inflater,container,false)
        val moviesRepository = MoviesRepository()
        val viewModelProvider = MoviesDetailViewModelProvider(moviesRepository)
        movieDetailsViewModel = ViewModelProvider(this,viewModelProvider).get(MovieDetailViewModel::class.java)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setData(safeArgs.result)
        movieDetailsViewModel.getMovieTrailer(api_key,safeArgs.result.id.toString())
        observeMoviesList()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding.ytVideoView.release()
    }

    companion object{
        const val api_key = "b2be7c6263d4844e6a6565c38e728c5f"
    }

    private fun setData(result:Result){
        with(binding){
            appCompatImageView.setImage(result.posterPath)
            movieTitle.text = result.title
            movieGenre.text = result.originalLanguage
            releaseData.text = result.releaseDate

        }
    }

    private fun observeMoviesList(){
        movieDetailsViewModel.movieTrailer.observe(viewLifecycleOwner, Observer { response ->
            when(response){
                is Resource.Success ->{
                    response.data?.results?.get(0)?.key?.let { initYoutubePlayer(it) }
                }
                is Resource.Error ->{
                    response.message.let {
                        Toast.makeText(context, "Error", Toast.LENGTH_SHORT).show()
                    }
                }
                else -> {

                }
            }
        })
    }

    private fun initYoutubePlayer(youtubeId: String) {
        lifecycle.addObserver(binding.ytVideoView)
        binding.ytVideoView.addYouTubePlayerListener(object :
            AbstractYouTubePlayerListener() {
            override fun onReady(youTubePlayer: YouTubePlayer) {
                youTubePlayer.cueVideo(youtubeId, 0.0F)
            }
        }
        )
    }


}