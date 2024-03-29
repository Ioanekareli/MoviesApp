package com.example.moviesapp.common.data.api.dto.popularmoviesDto

import com.google.gson.annotations.SerializedName

data class PopularMoviesDto(
    val page: Int,
    @SerializedName("results")
    val popularMoviesResultDto: List<PopularMoviesDetailsDto>,
    @SerializedName("total_pages")
    val totalPages: Int,
    @SerializedName("total_results")
    val totalResults: Int?
)