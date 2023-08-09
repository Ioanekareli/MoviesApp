package com.example.moviesapp.common.data.api.api_mapper.castcrewmapper

import com.example.moviesapp.common.data.api.api_mapper.ApiMapper
import com.example.moviesapp.common.data.api.dto.castcrewDto.CrewDetailsDto
import com.example.moviesapp.common.domain.model.castcrew.Crew
import javax.inject.Inject

class CrewMapper @Inject constructor():ApiMapper<CrewDetailsDto,Crew> {
    override fun mapToDomain(apiEntity: CrewDetailsDto): Crew {
        with(apiEntity){
            return Crew(
                name = name.orEmpty(),
                job = job.orEmpty(),
                profile = profilePath.orEmpty()
            )
        }
    }
}