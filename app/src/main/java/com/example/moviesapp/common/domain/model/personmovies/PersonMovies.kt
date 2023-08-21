package com.example.moviesapp.common.domain.model.personmovies

data class PersonMovies(
    val cast: List<MoviesAsCast>,
    val crew: List<MoviesAsCrew>,
    val id: Int
)