package com.example.moviesapp.common.data.api.dto.similarmoviesDto

import com.google.gson.annotations.SerializedName

data class SimilarMoviesDto(
    val page: Int,
    val results: List<SimilarMoviesDetailsDto>,
    @SerializedName("total_pages")
    val totalPages: Int?,
    @SerializedName("total_results")
    val totalResults: Int?
)