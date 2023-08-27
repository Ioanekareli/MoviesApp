package com.example.moviesapp.common.presentation.mymovies

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.moviesapp.common.data.db.entity.mymovies.MyMovieEntity
import com.example.moviesapp.common.data.repository.MyMoviesRepositoryImpl
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MyMoviesViewModel @Inject constructor(
    private val myMoviesRepositoryImpl: MyMoviesRepositoryImpl
):ViewModel(){

    private val _myMovies = MutableLiveData<List<MyMovieEntity>>()
    val myMovies:LiveData<List<MyMovieEntity>> get() = _myMovies

    fun loadMyMovies() = viewModelScope.launch {
       _myMovies.postValue(myMoviesRepositoryImpl.getAllMovies())
    }

    fun deleteMovie(movieId:Int) = viewModelScope.launch {
        myMoviesRepositoryImpl.deleteMovie(movieId)
    }

}