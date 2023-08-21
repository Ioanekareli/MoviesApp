package com.example.moviesapp.common.data.api.dto.personmoviesDto

data class PersonMoviesDto(
    val cast: List<CastDto>,
    val crew: List<CrewDto>,
    val id: Int?
)