package com.example.moviesapp.common.data.api.api_mapper.trailerMapper

import com.example.moviesapp.common.data.api.api_mapper.ApiMapper
import com.example.moviesapp.common.data.api.dto.trailerDto.TrailerListDto
import com.example.moviesapp.common.domain.model.trailer.TrailerList
import javax.inject.Inject

class TrailerListMapper @Inject constructor():
    ApiMapper<TrailerListDto,TrailerList> {
    override fun mapToDomain(apiEntity: TrailerListDto): TrailerList {
        return TrailerList(
            key = apiEntity.key.orEmpty(),
            type = apiEntity.type.orEmpty()
        )
    }
}