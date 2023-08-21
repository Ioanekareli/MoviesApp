package com.example.moviesapp.common.presentation.poster

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.moviesapp.common.data.repository.MoviePostersRepositoryImpl
import com.example.moviesapp.common.domain.model.movieposters.MoviePosters
import com.example.moviesapp.common.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MoviePostersViewModel @Inject constructor(
    private val moviePostersRepositoryImpl: MoviePostersRepositoryImpl
):ViewModel() {

    val moviePoster:LiveData<Resource<MoviePosters>> get() = _moviePosters
    private val _moviePosters = MutableLiveData<Resource<MoviePosters>>()

    fun loadPosters(movieId:Int){
        viewModelScope.launch {
            _moviePosters.value = moviePostersRepositoryImpl.getPosters(movieId)
        }
    }

}