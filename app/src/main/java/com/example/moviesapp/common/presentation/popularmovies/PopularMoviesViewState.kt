package com.example.moviesapp.common.presentation.popularmovies

import com.example.moviesapp.common.domain.model.PopularMoviesDetails

data class PopularMoviesViewState(
    val loading:Boolean = true,
    val popularMovies:List<PopularMoviesDetails> = emptyList(),
    val noMorePopularMovies:Boolean = false,
    val failure:Throwable? = null
)


