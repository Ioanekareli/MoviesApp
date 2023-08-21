package com.example.moviesapp.common.domain.repository

import com.example.moviesapp.common.domain.model.personmovies.PersonMovies
import com.example.moviesapp.common.utils.Resource

interface PersonMoviesRepository {

    suspend fun getPersonMovies(personId:Int):Resource<PersonMovies>

}