package com.example.moviesapp.common.data.api.api_service

import com.example.moviesapp.common.data.api.ApiConstants
import com.example.moviesapp.common.data.api.dto.popularpeopleDto.PopularPeopleDto
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface PeopleApiService {

    @GET(ApiConstants.PEOPLE_ENDPOINT)
    suspend fun getPeople(
        @Query("api_key") apiKey:String,
        @Query("page") page:Int
    ):Response<PopularPeopleDto>


}