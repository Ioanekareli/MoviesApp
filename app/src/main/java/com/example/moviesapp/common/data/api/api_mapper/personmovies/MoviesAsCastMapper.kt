package com.example.moviesapp.common.data.api.api_mapper.personmovies

import com.example.moviesapp.common.data.api.api_mapper.ApiMapper
import com.example.moviesapp.common.data.api.dto.personmoviesDto.CastDto
import com.example.moviesapp.common.domain.model.personmovies.MoviesAsCast
import javax.inject.Inject

class MoviesAsCastMapper @Inject constructor()
    :ApiMapper<CastDto,MoviesAsCast>
{
    override fun mapToDomain(apiEntity: CastDto): MoviesAsCast {
        return MoviesAsCast(
            profile = apiEntity.posterPath.orEmpty()
        )
    }
}