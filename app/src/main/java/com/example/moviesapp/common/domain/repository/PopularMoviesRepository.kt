package com.example.moviesapp.common.domain.repository

import com.example.moviesapp.common.domain.model.PopularMovies
import com.example.moviesapp.common.utils.Resource

interface PopularMoviesRepository  {

    suspend fun getPopularMovies(apiKey:String,page:Int): Resource<PopularMovies>

}