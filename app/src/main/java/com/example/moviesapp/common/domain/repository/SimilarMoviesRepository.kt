package com.example.moviesapp.common.domain.repository

import com.example.moviesapp.common.domain.model.similarmovies.SimilarMovies
import com.example.moviesapp.common.utils.Resource

interface SimilarMoviesRepository {

    suspend fun getSimilarMovies(movieId:Int):Resource<SimilarMovies>

}