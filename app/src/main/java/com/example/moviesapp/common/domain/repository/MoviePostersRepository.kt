package com.example.moviesapp.common.domain.repository

import com.example.moviesapp.common.domain.model.movieposters.MoviePosters
import com.example.moviesapp.common.utils.Resource

interface MoviePostersRepository {

    suspend fun getPosters(movieId:Int):Resource<MoviePosters>

}