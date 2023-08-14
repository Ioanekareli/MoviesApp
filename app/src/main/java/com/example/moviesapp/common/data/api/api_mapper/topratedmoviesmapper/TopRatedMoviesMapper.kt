package com.example.moviesapp.common.data.api.api_mapper.topratedmoviesmapper

import com.example.moviesapp.common.data.api.api_mapper.ApiMapper
import com.example.moviesapp.common.data.api.dto.topratedmoviesDto.TopRatedMoviesDto
import com.example.moviesapp.common.domain.model.topratedmovies.TopRatedMovies
import javax.inject.Inject

class TopRatedMoviesMapper @Inject constructor(
    private val topRatedMoviesListMapper: TopRatedMoviesListMapper
) :ApiMapper<TopRatedMoviesDto,TopRatedMovies> {
    override fun mapToDomain(apiEntity: TopRatedMoviesDto): TopRatedMovies {
        return TopRatedMovies(
            page = apiEntity.page?:0,
            topRatedMoviesList = topRatedMoviesListMapper.mapListToDomain(apiEntity.results)
        )
    }
}