package com.example.moviesapp.common.domain.model

data class PopularMovies (
    val page:Int?,
    val results:List<PopularMoviesList>
)