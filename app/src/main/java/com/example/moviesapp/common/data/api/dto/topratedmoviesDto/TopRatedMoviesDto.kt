package com.example.moviesapp.common.data.api.dto.topratedmoviesDto

import com.google.gson.annotations.SerializedName

data class TopRatedMoviesDto(
    val page: Int?,
    val results: List<TopRatedMoviesListDto>,
    @SerializedName("total_pages")
    val totalPages: Int?,
    @SerializedName("total_results")
    val totalResults: Int?
)