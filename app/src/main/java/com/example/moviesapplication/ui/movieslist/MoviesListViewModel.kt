package com.example.moviesapplication.ui.movieslist

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.moviesapplication.dto.TopRatedMovieList
import com.example.moviesapplication.repository.MoviesRepository
import com.example.moviesapplication.utils.Resource
import kotlinx.coroutines.launch
import retrofit2.Response

class MoviesListViewModel(private val moviesRepository: MoviesRepository):ViewModel(){
    val movieList:MutableLiveData<Resource<TopRatedMovieList>> = MutableLiveData()

    fun getMoviesList(api_key:String) = viewModelScope.launch {
        movieList.postValue(Resource.Loading(true))
        val response = moviesRepository.getMovies(api_key)
        movieList.postValue(loadMoviesList(response))
        Log.d("123", "observeMoviesList: $response")
    }

    private fun loadMoviesList(response:Response<TopRatedMovieList>):Resource<TopRatedMovieList>{
        if (response.isSuccessful && response.body() != null){
            response.body().let {
                return Resource.Success(it!!)
            }
        }
        return Resource.Error(response.message(),data = null)
    }

}