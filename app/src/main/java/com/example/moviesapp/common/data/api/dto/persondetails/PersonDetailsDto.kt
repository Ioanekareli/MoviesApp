package com.example.moviesapp.common.data.api.dto.persondetails

import com.google.gson.annotations.SerializedName

data class PersonDetailsDto(
    val adult: Boolean?,
    val also_known_as: List<String>?,
    val biography: String?,
    val birthday: String?,
    @SerializedName("deathday")
    val deathDay: String?,
    val gender: Int?,
    val homepage: String?,
    val id: Int?,
    val imdb_id: String?,
    @SerializedName("known_for_department")
    val knownForDepartment: String?,
    val name: String?,
    val place_of_birth: String?,
    val popularity: Double?,
    @SerializedName("profile_path")
    val profilePath: String?
)