package com.example.moviesapp.common.data.api.api_mapper.moviesdetailsmapper

import com.example.moviesapp.common.data.api.api_mapper.ApiMapper
import com.example.moviesapp.common.data.api.api_mapper.MappingException
import com.example.moviesapp.common.data.api.dto.moviedetailsDto.MovieDetailsDto
import com.example.moviesapp.common.domain.model.moviedetails.MovieDetails
import javax.inject.Inject

class MovieDetailsMapper @Inject constructor():ApiMapper<MovieDetailsDto,MovieDetails> {
    override fun mapToDomain(apiEntity: MovieDetailsDto): MovieDetails {
        with(apiEntity){
            return MovieDetails(
                id = id?:throw MappingException("Id can not be null"),
                backdropPath = backdropPath.orEmpty(),
                overview = overview.orEmpty(),
                posterPath = posterPath.orEmpty(),
                revenue = revenue?:0,
                runtime = runtime?:0,
                title = title.orEmpty(),
                video = video?:false,
            )
        }
    }
}