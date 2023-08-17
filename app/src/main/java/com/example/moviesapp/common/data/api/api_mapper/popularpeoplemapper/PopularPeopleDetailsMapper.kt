package com.example.moviesapp.common.data.api.api_mapper.popularpeoplemapper

import com.example.moviesapp.common.data.api.api_mapper.ApiMapper
import com.example.moviesapp.common.data.api.api_mapper.MappingException
import com.example.moviesapp.common.data.api.dto.popularpeopleDto.PopularPeopleDetailsDto
import com.example.moviesapp.common.domain.model.popularpeople.PopularPeopleDetails
import javax.inject.Inject

class PopularPeopleDetailsMapper @Inject constructor()
    :ApiMapper<PopularPeopleDetailsDto,PopularPeopleDetails> {
    override fun mapToDomain(apiEntity: PopularPeopleDetailsDto): PopularPeopleDetails {
        with(apiEntity){
            return PopularPeopleDetails(
                id = id?: throw MappingException("Id can not be null"),
                gender = gender?:-1,
                name = name.orEmpty(),
                profile = profilePath.orEmpty()
            )
        }
    }

}