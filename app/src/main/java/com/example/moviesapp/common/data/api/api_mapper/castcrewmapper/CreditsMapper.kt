package com.example.moviesapp.common.data.api.api_mapper.castcrewmapper

import com.example.moviesapp.common.data.api.api_mapper.ApiMapper
import com.example.moviesapp.common.data.api.dto.castcrewDto.CreditsDto
import com.example.moviesapp.common.domain.model.castcrew.Credits
import javax.inject.Inject

class CreditsMapper @Inject constructor(
    private val crewMapper: CrewMapper,
    private val castMapper: CastMapper
):ApiMapper<CreditsDto,Credits> {
    override fun mapToDomain(apiEntity: CreditsDto): Credits {
        return Credits(
            movieId = apiEntity.movieId,
            castDetails = castMapper.mapListToDomain(apiEntity.castDetails),
            crewDetails = crewMapper.mapListToDomain(apiEntity.crewDetails),
        )
    }
}