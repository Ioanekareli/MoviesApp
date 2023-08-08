package com.example.moviesapp.common.presentation.moviedetails

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.moviesapp.common.data.repository.MovieDetailsRepositoryImpl
import com.example.moviesapp.common.data.repository.TrailersRepositoryImpl
import com.example.moviesapp.common.domain.model.moviedetails.MovieDetails
import com.example.moviesapp.common.domain.model.trailer.Trailer
import com.example.moviesapp.common.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MovieDetailsViewModel @Inject constructor(
    private val movieDetailsRepositoryImpl: MovieDetailsRepositoryImpl,
    private val trailerRepositoryImpl: TrailersRepositoryImpl
):ViewModel() {


    val movieDetails:LiveData<Resource<MovieDetails>> get() = _movieDetails
    private val _movieDetails = MutableLiveData<Resource<MovieDetails>>()

    val trailer:LiveData<Resource<Trailer>> get() = _trailer
    private val _trailer = MutableLiveData<Resource<Trailer>>()

    fun loadMovieDetails(movieId:Int){
        viewModelScope.launch {
            _movieDetails.value = movieDetailsRepositoryImpl.getMovieDetails(movieId)
        }
    }

    fun getTrailer(movieId: Int){
        viewModelScope.launch {
            _trailer.value = trailerRepositoryImpl.getTrailer(movieId)
        }
    }

}