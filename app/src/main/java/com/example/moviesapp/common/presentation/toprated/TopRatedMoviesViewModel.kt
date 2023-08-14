package com.example.moviesapp.common.presentation.toprated

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.moviesapp.common.data.repository.TopRatedMoviesRepositoryImpl
import com.example.moviesapp.common.domain.model.topratedmovies.TopRatedMovies
import com.example.moviesapp.common.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TopRatedMoviesViewModel @Inject constructor(
    private val repositoryImpl: TopRatedMoviesRepositoryImpl
):ViewModel() {

    val topRatedMovies:LiveData<Resource<TopRatedMovies>> get() = _topRatedMovies
    private val _topRatedMovies = MutableLiveData<Resource<TopRatedMovies>>()

    fun loadMovies(){
        viewModelScope.launch {
            _topRatedMovies.value = repositoryImpl.getTopRatedMovies(1)
        }
    }

}