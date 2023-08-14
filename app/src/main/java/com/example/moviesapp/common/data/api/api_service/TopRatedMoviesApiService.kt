package com.example.moviesapp.common.data.api.api_service

import com.example.moviesapp.common.data.api.ApiConstants
import com.example.moviesapp.common.data.api.dto.topratedmoviesDto.TopRatedMoviesDto
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface TopRatedMoviesApiService {

    @GET(ApiConstants.TOP_RATED_MOVIES_ENDPOINT)
    suspend fun getTopRatedMovies(
        @Query("api_key") apiKey:String,
        @Query("page") page: Int
    ):Response<TopRatedMoviesDto>

}