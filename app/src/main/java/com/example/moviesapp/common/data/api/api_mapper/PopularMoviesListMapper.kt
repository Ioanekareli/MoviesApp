package com.example.moviesapp.common.data.api.api_mapper

import com.example.moviesapp.common.data.api.dto.PopularMoviesListDto
import com.example.moviesapp.common.domain.model.PopularMoviesList

class PopularMoviesListMapper : ApiMapper<PopularMoviesListDto, PopularMoviesList> {
    override fun mapToDomain(apiEntity:PopularMoviesListDto): PopularMoviesList {
        with(apiEntity){
            return PopularMoviesList(
                id = id?:throw MappingException("id can not be null"),
                adult = apiEntity.adult?:false,
                genreIds = apiEntity.genreIds.orEmpty(),
                overview = apiEntity.overview.orEmpty(),
                popularity = apiEntity.popularity?:-1.0,
                posterPath = apiEntity.posterPath.orEmpty(),
                releaseData = apiEntity.releaseDate.orEmpty(),
                title = apiEntity.title.orEmpty()
            )
        }
    }
}