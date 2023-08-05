package com.example.moviesapp.common.presentation.popularmovies

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.moviesapp.common.data.api.ApiConstants
import com.example.moviesapp.common.data.repository.PopularMoviesRepositoryImpl
import com.example.moviesapp.common.domain.model.popularmovies.PopularMovies
import com.example.moviesapp.common.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PopularMoviesViewModel @Inject constructor(
    private val repositoryImpl: PopularMoviesRepositoryImpl
): ViewModel() {

    val popularMovies:LiveData<Resource<PopularMovies>> get() = _popularMovies
    private val _popularMovies = MutableLiveData<Resource<PopularMovies>>()

    init {
        loadMovies()
    }

    private fun loadMovies(){
        viewModelScope.launch {
            _popularMovies.value = repositoryImpl.getPopularMovies(1)
        }
    }

}