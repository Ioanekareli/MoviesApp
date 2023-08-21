package com.example.moviesapp.common.data.api.api_service

import com.example.moviesapp.common.data.api.ApiConstants
import com.example.moviesapp.common.data.api.dto.persondetails.PersonDetailsDto
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface PersonDetailsApiService {

    @GET(ApiConstants.PERSON_DETAILS_ENDPOINT)
    suspend fun getPersonDetails(
        @Path("person_id") personId:Int,
        @Query("api_key") apiKey:String
    ):Response<PersonDetailsDto>

}