package com.example.moviesapp.common.data.api.api_mapper.popularpeoplemapper

import com.example.moviesapp.common.data.api.api_mapper.ApiMapper
import com.example.moviesapp.common.data.api.dto.popularpeopleDto.PopularPeopleDto
import com.example.moviesapp.common.domain.model.popularpeople.PopularPeople
import javax.inject.Inject

class PopularPeopleMapper @Inject constructor(
    private val popularPeopleDetailsMapper: PopularPeopleDetailsMapper
):ApiMapper<PopularPeopleDto,PopularPeople>
{
    override fun mapToDomain(apiEntity: PopularPeopleDto): PopularPeople {
        return PopularPeople(
            page = apiEntity.page?:1,
            popularPeopleDetails = popularPeopleDetailsMapper.mapListToDomain(apiEntity.results.orEmpty())
        )
    }
}