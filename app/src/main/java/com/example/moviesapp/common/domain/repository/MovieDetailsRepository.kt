package com.example.moviesapp.common.domain.repository

import com.example.moviesapp.common.domain.model.moviedetails.MovieDetails
import com.example.moviesapp.common.utils.Resource

interface MovieDetailsRepository {

    suspend fun getMovieDetails(movieId:String): Resource<MovieDetails>

}