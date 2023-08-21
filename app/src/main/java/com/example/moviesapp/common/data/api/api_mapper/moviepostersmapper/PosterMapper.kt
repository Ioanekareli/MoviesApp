package com.example.moviesapp.common.data.api.api_mapper.moviepostersmapper

import com.example.moviesapp.common.data.api.api_mapper.ApiMapper
import com.example.moviesapp.common.data.api.dto.moviepostersDto.PosterDto
import com.example.moviesapp.common.domain.model.movieposters.Posters
import javax.inject.Inject

class PosterMapper @Inject constructor()
    :ApiMapper<PosterDto,Posters> {
    override fun mapToDomain(apiEntity: PosterDto): Posters {
        return Posters(
            filePath = apiEntity.filePath.orEmpty()
        )
    }
}