package com.example.moviesapp.common.domain.model.moviedetails

data class MovieDetails(
    val id:Int,
    val backdropPath:String,
    val overview:String,
    val posterPath:String,
    val budget:Int,
    val runtime:Int,
    val title:String,
    val video:Boolean,
    val genre: List<Genre>,
    val countries:List<Countries>
)