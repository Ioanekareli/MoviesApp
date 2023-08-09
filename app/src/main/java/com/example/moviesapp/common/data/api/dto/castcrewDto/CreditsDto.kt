package com.example.moviesapp.common.data.api.dto.castcrewDto

import com.google.gson.annotations.SerializedName

data class CreditsDto(
    @SerializedName("cast")
    val castDetails: List<CastDetailsDto>,
    @SerializedName("crew")
    val crewDetails: List<CrewDetailsDto>,
    @SerializedName("id")
    val movieId: Int
)