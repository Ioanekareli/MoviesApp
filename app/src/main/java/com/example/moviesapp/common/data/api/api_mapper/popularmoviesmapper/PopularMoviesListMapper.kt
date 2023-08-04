package com.example.moviesapp.common.data.api.api_mapper.popularmoviesmapper

import com.example.moviesapp.common.data.api.api_mapper.ApiMapper
import com.example.moviesapp.common.data.api.api_mapper.MappingException
import com.example.moviesapp.common.data.api.dto.popularmoviesDto.PopularMoviesDetailsDto
import com.example.moviesapp.common.domain.model.popularmovies.PopularMoviesDetails
import javax.inject.Inject

class PopularMoviesListMapper @Inject constructor() :
    ApiMapper<PopularMoviesDetailsDto, PopularMoviesDetails> {
    override fun mapToDomain(apiEntity: PopularMoviesDetailsDto): PopularMoviesDetails {
        with(apiEntity){
            return PopularMoviesDetails(
                id = id?:throw MappingException("id can not be null"),
                adult = adult?:false,
                genreIds = genreIds.orEmpty(),
                overview = overview.orEmpty(),
                popularity = popularity?:-1.0,
                posterPath = posterPath.orEmpty(),
                releaseData = releaseDate.orEmpty(),
                title = title.orEmpty()
            )
        }
    }
}