package com.example.moviesapp.common.data.api.api_mapper.popularmoviesmapper

import com.example.moviesapp.common.data.api.api_mapper.ApiMapper
import com.example.moviesapp.common.data.api.dto.popularmoviesDto.PopularMoviesDto
import com.example.moviesapp.common.domain.model.popularmovies.PopularMovies
import javax.inject.Inject

class PopularMoviesMapper @Inject constructor(
    private val resultMapper: PopularMoviesListMapper
): ApiMapper<PopularMoviesDto, PopularMovies> {

    override fun mapToDomain(apiEntity: PopularMoviesDto): PopularMovies {
        with(apiEntity){
            return PopularMovies(
                page = page,
                results = resultMapper.mapListToDomain(apiEntity.popularMoviesResultDto)
            )

        }
    }

}