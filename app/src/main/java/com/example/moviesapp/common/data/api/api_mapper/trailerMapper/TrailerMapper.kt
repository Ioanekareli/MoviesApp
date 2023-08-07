package com.example.moviesapp.common.data.api.api_mapper.trailerMapper

import com.example.moviesapp.common.data.api.api_mapper.ApiMapper
import com.example.moviesapp.common.data.api.api_mapper.MappingException
import com.example.moviesapp.common.data.api.dto.trailerDto.TrailerDto
import com.example.moviesapp.common.domain.model.trailer.Trailer
import javax.inject.Inject

class TrailerMapper @Inject constructor(
    private val trailerListMapper: TrailerListMapper
): ApiMapper<TrailerDto,Trailer>{
    override fun mapToDomain(apiEntity: TrailerDto): Trailer {
        return Trailer(
            id = apiEntity.id ?: throw MappingException("id can not be null"),
            results = trailerListMapper.mapListToDomain(apiEntity.results)
        )
    }
}