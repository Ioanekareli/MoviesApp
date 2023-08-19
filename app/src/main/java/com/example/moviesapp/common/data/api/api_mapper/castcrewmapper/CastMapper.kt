package com.example.moviesapp.common.data.api.api_mapper.castcrewmapper

import com.example.moviesapp.common.data.api.api_mapper.ApiMapper
import com.example.moviesapp.common.data.api.api_mapper.MappingException
import com.example.moviesapp.common.data.api.dto.castcrewDto.CastDetailsDto
import com.example.moviesapp.common.domain.model.castcrew.Cast
import javax.inject.Inject

class CastMapper @Inject constructor():ApiMapper<CastDetailsDto,Cast> {
    override fun mapToDomain(apiEntity: CastDetailsDto): Cast {
        with(apiEntity){
            return Cast(
                name = name.orEmpty(),
                character = character.orEmpty(),
                profile = profilePath.orEmpty(),
                id = id?: throw MappingException("Id can not be null")
            )
        }
    }
}