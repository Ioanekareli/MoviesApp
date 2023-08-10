package com.example.moviesapp.common.data.api.api_mapper.similarmoviesmapper

import com.example.moviesapp.common.data.api.api_mapper.ApiMapper
import com.example.moviesapp.common.data.api.dto.similarmoviesDto.SimilarMoviesDto
import com.example.moviesapp.common.domain.model.similarmovies.SimilarMovies
import javax.inject.Inject

class SimilarMoviesMapper @Inject constructor(
    private val similarMoviesDetailsMapper: SimilarMoviesDetailsMapper
)
    :ApiMapper<SimilarMoviesDto, SimilarMovies> {
    override fun mapToDomain(apiEntity: SimilarMoviesDto): SimilarMovies {
        with(apiEntity){
            return SimilarMovies(
                page = page?:0,
                results = similarMoviesDetailsMapper.mapListToDomain(apiEntity.results)
            )
        }
    }
}