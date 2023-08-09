package com.example.moviesapp.common.data.api.api_service

import com.example.moviesapp.common.data.api.ApiConstants
import com.example.moviesapp.common.data.api.dto.castcrewDto.CreditsDto
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface CreditsApiService {

    @GET(ApiConstants.CAST_ENDPOINT)
    suspend fun getCast(
        @Path("movie_id") movieId:Int,
        @Query("api_key") apiKey:String
    ):Response<CreditsDto>

}