package com.example.moviesapplication.videosdto


import com.google.gson.annotations.SerializedName

data class MovieTrailers(
    @SerializedName("id")
    val id: Int,
    @SerializedName("results")
    val results: List<Result>
)