package com.example.moviesapp.common.domain.repository

import com.example.moviesapp.common.domain.model.topratedmovies.TopRatedMovies
import com.example.moviesapp.common.utils.Resource

interface TopRatedMoviesRepository {

    suspend fun getTopRatedMovies(page:Int):Resource<TopRatedMovies>

}