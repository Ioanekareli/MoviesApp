package com.example.moviesapp.common.domain.model.popularmovies

data class PopularMovies (
    val page:Int?,
    val results:List<PopularMoviesDetails>
)