package com.example.moviesapp.common.data.api.api_mapper

import com.example.moviesapp.common.data.api.dto.PopularMoviesDetailsDto
import com.example.moviesapp.common.domain.model.PopularMoviesDetails
import javax.inject.Inject

class PopularMoviesListMapper @Inject constructor() : ApiMapper<PopularMoviesDetailsDto, PopularMoviesDetails> {
    override fun mapToDomain(apiEntity:PopularMoviesDetailsDto): PopularMoviesDetails {
        with(apiEntity){
            return PopularMoviesDetails(
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