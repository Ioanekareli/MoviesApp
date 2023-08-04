package com.example.moviesapp.common.domain.model.popularmovies

data class PopularMoviesDetails (
    val id:Int,
    val adult:Boolean,
    val genreIds:List<Int>?,
    val overview:String,
    val popularity:Double,
    val posterPath:String,
    val releaseData:String,
    val title:String,
)