package com.example.moviesapp.common.data.api.api_mapper.personmovies

import com.example.moviesapp.common.data.api.api_mapper.ApiMapper
import com.example.moviesapp.common.data.api.api_mapper.MappingException
import com.example.moviesapp.common.data.api.dto.personmoviesDto.PersonMoviesDto
import com.example.moviesapp.common.domain.model.personmovies.PersonMovies
import javax.inject.Inject

class PersonMoviesMapper @Inject constructor(
    private val moviesAsCastMapper: MoviesAsCastMapper,
    private val moviesAsCrewMapper: MoviesAsCrewMapper
):ApiMapper<PersonMoviesDto, PersonMovies> {
    override fun mapToDomain(apiEntity: PersonMoviesDto): PersonMovies {
        return PersonMovies(
            cast = moviesAsCastMapper.mapListToDomain(apiEntity.cast),
            crew = moviesAsCrewMapper.mapListToDomain(apiEntity.crew),
            id = apiEntity.id?: throw MappingException("Id can not be null")
        )
    }
}
