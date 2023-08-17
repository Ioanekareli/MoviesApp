package com.example.moviesapp.common.data.api.dto.popularpeopleDto

import com.google.gson.annotations.SerializedName

data class PopularPeopleDto(
    val page: Int?,
    val results: List<PopularPeopleDetailsDto>?,
    @SerializedName("total_pages")
    val totalPages: Int,
    @SerializedName("total_results")
    val totalResults: Int
)