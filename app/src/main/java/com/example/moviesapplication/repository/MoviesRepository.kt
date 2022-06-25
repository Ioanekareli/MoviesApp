package com.example.moviesapplication.repository

import com.example.moviesapplication.dto.TopRatedMovieList
import com.example.moviesapplication.network.NetworkClient
import com.example.moviesapplication.videosdto.MovieTrailers
import retrofit2.Response

class MoviesRepository() {
    suspend fun getMovies(api_key:String):Response<TopRatedMovieList>{
        return  NetworkClient.api.getMovieList(api_key)

    }

    suspend fun getMovieTrailer(api_key: String,id:String):Response<MovieTrailers>{
        return NetworkClient.api.getMovieTrailer(id,api_key)
    }
}