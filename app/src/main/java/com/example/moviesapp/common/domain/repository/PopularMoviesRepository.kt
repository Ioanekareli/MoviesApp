package com.example.moviesapp.common.domain.repository

import com.example.moviesapp.common.domain.model.popularmovies.PopularMovies
import com.example.moviesapp.common.utils.Resource

interface PopularMoviesRepository  {

    suspend fun getPopularMovies(page:Int): Resource<PopularMovies>

}