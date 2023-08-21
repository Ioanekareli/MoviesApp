package com.example.moviesapp.common.data.api.api_mapper.moviepostersmapper

import com.example.moviesapp.common.data.api.api_mapper.ApiMapper
import com.example.moviesapp.common.data.api.api_mapper.MappingException
import com.example.moviesapp.common.data.api.dto.moviepostersDto.MoviePostersDto
import com.example.moviesapp.common.domain.model.movieposters.MoviePosters
import javax.inject.Inject

class MoviePostersMapper @Inject constructor(
    private val backdropMapper: BackdropMapper,
    private val posterMapper: PosterMapper
):ApiMapper<MoviePostersDto,MoviePosters> {
    override fun mapToDomain(apiEntity: MoviePostersDto): MoviePosters {
        return MoviePosters(
            id = apiEntity.id ?: throw MappingException("Id can not be null"),
            backdrops = backdropMapper.mapListToDomain(apiEntity.backdrops),
            posters = posterMapper.mapListToDomain(apiEntity.posters)
        )
    }
}