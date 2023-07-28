package com.example.moviesapp.common.data.api.api_service

import com.example.moviesapp.common.data.api.ApiConstants
import com.example.moviesapp.common.data.api.dto.PopularMoviesDto
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface PopularMoviesApiService {
    @GET(ApiConstants.POPULAR_MOVIES_ENDPOINT)
    suspend fun getPopularMovies(
        @Query("api_key") apiKey:String,
        @Query("page") page:Int,
    ): PopularMoviesDto
}