package com.example.moviesapp.common.data.api.dto.moviepostersDto

data class MoviePostersDto(
    val backdrops: List<BackdropDto>,
    val id: Int?,
    val logos: List<LogoDto>,
    val posters: List<PosterDto>
)