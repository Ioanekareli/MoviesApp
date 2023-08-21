package com.example.moviesapp.common.data.api.api_service

import com.example.moviesapp.common.data.api.ApiConstants
import com.example.moviesapp.common.data.api.dto.castcrewDto.CreditsDto
import com.example.moviesapp.common.data.api.dto.personmoviesDto.PersonMoviesDto
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface PersonMoviesApiService {

    @GET(ApiConstants.PERSON_MOVIES_ENDPOINT)
    suspend fun getPersonMovies(
        @Path("person_id") personId:Int,
        @Query("api_key") apiKey:String
    ):Response<PersonMoviesDto>

}