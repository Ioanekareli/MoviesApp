package com.example.moviesapp.common.data.api.api_service

import com.example.moviesapp.common.data.api.ApiConstants
import com.example.moviesapp.common.data.api.dto.PopularMoviesDto
import retrofit2.http.GET
import retrofit2.http.Query

interface PopularMoviesApiService {
    @GET(ApiConstants.POPULAR_MOVIES_ENDPOINT)
    suspend fun getPopularMovies(
        @Query(ApiConstants.API_KEY) apiKey:String,
        @Query(ApiConstants.PAGE) page:Int
    ): PopularMoviesDto
}