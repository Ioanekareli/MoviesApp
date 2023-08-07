package com.example.moviesapp.common.data.api.api_service

import com.example.moviesapp.common.data.api.ApiConstants
import com.example.moviesapp.common.data.api.dto.trailerDto.TrailerDto
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface TrailerApiService {

    @GET(ApiConstants.TRAILER_ENDPOINT)
    suspend fun getMovieTrailer(
        @Path("movie_id") movieId:Int,
        @Query("api_key") apiKey:String
    ):Response<TrailerDto>

}