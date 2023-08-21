package com.example.moviesapp.common.data.repository

import com.example.moviesapp.common.data.api.ApiConstants
import com.example.moviesapp.common.data.api.api_mapper.castcrewmapper.CreditsMapper
import com.example.moviesapp.common.data.api.api_mapper.personmovies.PersonMoviesMapper
import com.example.moviesapp.common.data.api.api_service.PersonMoviesApiService
import com.example.moviesapp.common.domain.model.personmovies.PersonMovies
import com.example.moviesapp.common.domain.repository.PersonMoviesRepository
import com.example.moviesapp.common.utils.Resource
import javax.inject.Inject

class PersonMoviesRepositoryImpl @Inject constructor(
    private val apiService: PersonMoviesApiService,
    private val mapper:PersonMoviesMapper
):PersonMoviesRepository {
    override suspend fun getPersonMovies(personId: Int): Resource<PersonMovies> {
        return try {
            val response = apiService.getPersonMovies(personId,ApiConstants.API_KEY)
            val responseBody = response.body()
            if (response.isSuccessful && responseBody != null){
                val data = mapper.mapToDomain(responseBody)
                Resource.Success(data)
            }else{
                Resource.Error(response.message())
            }
        }catch (e:Exception){
            Resource.Error(e.message)
        }
    }
}