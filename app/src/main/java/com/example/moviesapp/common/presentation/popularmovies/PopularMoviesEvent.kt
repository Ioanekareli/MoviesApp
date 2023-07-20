package com.example.moviesapp.common.presentation.popularmovies

sealed class PopularMoviesEvent {

    object RequestPopularMoviesList:PopularMoviesEvent()

    object RequestMorePopularMovies:PopularMoviesEvent()

}