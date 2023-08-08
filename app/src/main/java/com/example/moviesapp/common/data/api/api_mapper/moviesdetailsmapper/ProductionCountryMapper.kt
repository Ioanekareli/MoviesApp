package com.example.moviesapp.common.data.api.api_mapper.moviesdetailsmapper

import com.example.moviesapp.common.data.api.api_mapper.ApiMapper
import com.example.moviesapp.common.data.api.dto.moviedetailsDto.ProductionCountryDto
import com.example.moviesapp.common.domain.model.moviedetails.Countries
import javax.inject.Inject

class ProductionCountryMapper @Inject constructor():ApiMapper<ProductionCountryDto,Countries> {
    override fun mapToDomain(apiEntity: ProductionCountryDto): Countries {
        return Countries(
            countyCode = apiEntity.countryCode.orEmpty(),
            name = apiEntity.name.orEmpty()
        )
    }
}