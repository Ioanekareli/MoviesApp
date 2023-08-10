package com.example.moviesapp.common.domain.model.similarmovies

data class SimilarMovies(
    val page: Int,
    val results: List<SimilarMoviesDetails>,
)
