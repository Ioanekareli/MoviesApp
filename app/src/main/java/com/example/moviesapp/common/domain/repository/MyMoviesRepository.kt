package com.example.moviesapp.common.domain.repository

import com.example.moviesapp.common.data.db.entity.mymovies.MyMovieEntity

interface MyMoviesRepository {

    suspend fun getAllMovies():List<MyMovieEntity>

    suspend fun insertMovie(movie:MyMovieEntity)

    suspend fun deleteMovie(movieId:Int)

}