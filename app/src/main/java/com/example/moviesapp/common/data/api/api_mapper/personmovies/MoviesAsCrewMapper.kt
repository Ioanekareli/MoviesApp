package com.example.moviesapp.common.data.api.api_mapper.personmovies

import com.example.moviesapp.common.data.api.api_mapper.ApiMapper
import com.example.moviesapp.common.data.api.dto.personmoviesDto.CrewDto
import com.example.moviesapp.common.domain.model.personmovies.MoviesAsCrew
import javax.inject.Inject

class MoviesAsCrewMapper @Inject constructor()
    :ApiMapper<CrewDto,MoviesAsCrew>
{
    override fun mapToDomain(apiEntity: CrewDto): MoviesAsCrew {
        return MoviesAsCrew(
            profile = apiEntity.posterPath.orEmpty()
        )
    }

}