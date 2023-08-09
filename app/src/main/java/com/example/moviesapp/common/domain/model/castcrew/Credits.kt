package com.example.moviesapp.common.domain.model.castcrew

data class Credits(
    val movieId: Int,
    val castDetails: List<Cast>,
    val crewDetails: List<Crew>
)
