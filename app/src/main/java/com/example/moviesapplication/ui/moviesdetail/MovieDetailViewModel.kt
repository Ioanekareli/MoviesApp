package com.example.moviesapplication.ui.moviesdetail

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.moviesapplication.repository.MoviesRepository
import com.example.moviesapplication.utils.Resource
import com.example.moviesapplication.videosdto.MovieTrailers
import kotlinx.coroutines.launch
import retrofit2.Response

class MovieDetailViewModel(private val moviesRepository: MoviesRepository):ViewModel() {

    val movieTrailer:MutableLiveData<Resource<MovieTrailers>> = MutableLiveData()

    fun getMovieTrailer(api_key:String,path_id:String) = viewModelScope.launch {
        movieTrailer.postValue(Resource.Loading(true))
        val response = moviesRepository.getMovieTrailer(api_key,path_id)
        movieTrailer.postValue(loadMovieTrailer(response))
    }

    private fun loadMovieTrailer(response:Response<MovieTrailers>):Resource<MovieTrailers>{
        if (response.isSuccessful && response.body() != null){
            response.body().let {
                return Resource.Success(it!!)
            }
        }
        return Resource.Error(response.message(),data = null)
    }
}