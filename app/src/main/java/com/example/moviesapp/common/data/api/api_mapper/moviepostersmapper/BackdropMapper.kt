package com.example.moviesapp.common.data.api.api_mapper.moviepostersmapper

import com.example.moviesapp.common.data.api.api_mapper.ApiMapper
import com.example.moviesapp.common.data.api.dto.moviepostersDto.BackdropDto
import com.example.moviesapp.common.domain.model.movieposters.Backdrop
import javax.inject.Inject

class BackdropMapper @Inject constructor()
    :ApiMapper<BackdropDto,Backdrop>
{
    override fun mapToDomain(apiEntity: BackdropDto): Backdrop {
        return Backdrop(
            filePath = apiEntity.filePath.orEmpty()
        )
    }
}