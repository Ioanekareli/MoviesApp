package com.example.moviesapp.common.data.api.dto.moviepostersDto

import com.google.gson.annotations.SerializedName

data class BackdropDto(
    val aspect_ratio: Double,
    @SerializedName("file_path")
    val filePath: String?,
    val height: Int,
    val iso_639_1: String,
    val vote_average: Double,
    val vote_count: Int,
    val width: Int
)