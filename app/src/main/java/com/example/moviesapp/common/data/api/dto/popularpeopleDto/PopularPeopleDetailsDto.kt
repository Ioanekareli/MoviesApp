package com.example.moviesapp.common.data.api.dto.popularpeopleDto

import com.google.gson.annotations.SerializedName

data class PopularPeopleDetailsDto(
    val adult: Boolean,
    val gender: Int?,
    val id: Int?,
    val known_for: List<KnownForDto>,
    val known_for_department: String,
    val name: String?,
    val popularity: Double,
    @SerializedName("profile_path")
    val profilePath: String?
)