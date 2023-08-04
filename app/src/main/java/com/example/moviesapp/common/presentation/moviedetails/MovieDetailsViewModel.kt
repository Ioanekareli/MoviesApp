package com.example.moviesapp.common.presentation.moviedetails

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.moviesapp.common.data.repository.MovieDetailsRepositoryImpl
import com.example.moviesapp.common.domain.model.moviedetails.MovieDetails
import com.example.moviesapp.common.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MovieDetailsViewModel @Inject constructor(
    private val repositoryImpl: MovieDetailsRepositoryImpl
):ViewModel() {


    val movieDetails:LiveData<Resource<MovieDetails>> get() = _movieDetails
    private val _movieDetails = MutableLiveData<Resource<MovieDetails>>()

    init {
        loadMovieDetails()
    }

    private fun loadMovieDetails(){
        viewModelScope.launch {
            _movieDetails.value = repositoryImpl.getMovieDetails("500")
        }
    }

}