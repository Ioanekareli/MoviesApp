package com.example.moviesapp.common.data.api.dto.moviedetailsDto

import com.google.gson.annotations.SerializedName

data class ProductionCountryDto(
    @SerializedName("iso_3166_1")
    val countryCode: String?,
    val name: String?
)