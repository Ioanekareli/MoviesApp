package com.example.moviesapp.common.data.api.dto.castcrewDto

import com.google.gson.annotations.SerializedName

data class CrewDetailsDto(
    val adult: Boolean?,
    val credit_id: String?,
    val department: String?,
    val gender: Int?,
    val id: Int?,
    val job: String?,
    val known_for_department: String?,
    val name: String?,
    val original_name: String?,
    val popularity: Double?,
    @SerializedName("profile_path")
    val profilePath: String?
)