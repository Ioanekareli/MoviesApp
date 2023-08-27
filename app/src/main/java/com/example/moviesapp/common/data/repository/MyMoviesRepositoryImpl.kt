package com.example.moviesapp.common.data.repository

import com.example.moviesapp.common.data.db.dao.MyMoviesDao
import com.example.moviesapp.common.data.db.entity.mymovies.MyMovieEntity
import com.example.moviesapp.common.domain.repository.MyMoviesRepository
import javax.inject.Inject

class MyMoviesRepositoryImpl @Inject constructor(
    private val myMoviesDao: MyMoviesDao,
):MyMoviesRepository {
    override suspend fun getAllMovies(): List<MyMovieEntity>{
        return myMoviesDao.getAllMovies()
    }

    override suspend fun insertMovie(movie: MyMovieEntity) {
        myMoviesDao.addMovie(movie)
    }

    override suspend fun deleteMovie(movieId: Int) {
        myMoviesDao.deleteCard(movieId)
    }

}