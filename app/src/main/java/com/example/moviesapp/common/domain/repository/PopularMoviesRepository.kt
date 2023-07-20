package com.example.moviesapp.common.domain.repository

import com.example.moviesapp.common.domain.model.PopularMovies

interface PopularMoviesRepository  {

    suspend fun getPopularMovies(apiKey:String,page:Int): PopularMovies

}