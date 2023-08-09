package com.example.moviesapp.common.data.api.dto.castcrewDto

import com.google.gson.annotations.SerializedName

data class CastDetailsDto(
    val adult: Boolean?,
    val cast_id: Int?,
    val character: String?,
    val credit_id: String?,
    val gender: Int?,
    val id: Int?,
    val known_for_department: String?,
    val name: String?,
    val order: Int?,
    val original_name: String?,
    val popularity: Double?,
    @SerializedName("profile_path")
    val profilePath: String?
)