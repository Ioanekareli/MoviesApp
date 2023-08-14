package com.example.moviesapp.common.data.api.api_mapper.topratedmoviesmapper

import com.example.moviesapp.common.data.api.api_mapper.ApiMapper
import com.example.moviesapp.common.data.api.api_mapper.MappingException
import com.example.moviesapp.common.data.api.dto.topratedmoviesDto.TopRatedMoviesListDto
import com.example.moviesapp.common.domain.model.topratedmovies.TopRatedMoviesList
import javax.inject.Inject

class TopRatedMoviesListMapper @Inject constructor():ApiMapper<TopRatedMoviesListDto,TopRatedMoviesList>{
    override fun mapToDomain(apiEntity: TopRatedMoviesListDto): TopRatedMoviesList {
        return TopRatedMoviesList(
            poster = apiEntity.posterPath.orEmpty(),
            id = apiEntity.id ?: throw MappingException("Id can not be null")
        )
    }
}