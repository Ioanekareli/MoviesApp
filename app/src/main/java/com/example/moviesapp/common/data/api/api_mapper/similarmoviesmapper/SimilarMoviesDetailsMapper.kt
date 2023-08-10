package com.example.moviesapp.common.data.api.api_mapper.similarmoviesmapper

import com.example.moviesapp.common.data.api.api_mapper.ApiMapper
import com.example.moviesapp.common.data.api.dto.similarmoviesDto.SimilarMoviesDetailsDto
import com.example.moviesapp.common.domain.model.similarmovies.SimilarMoviesDetails
import javax.inject.Inject

class SimilarMoviesDetailsMapper @Inject constructor()
    :ApiMapper<SimilarMoviesDetailsDto,SimilarMoviesDetails>{
    override fun mapToDomain(apiEntity: SimilarMoviesDetailsDto): SimilarMoviesDetails {
        with(apiEntity){
            return SimilarMoviesDetails(
                posterPath = posterPath.orEmpty()
            )
        }
    }
}