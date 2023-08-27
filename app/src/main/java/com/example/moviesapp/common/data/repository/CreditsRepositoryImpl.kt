package com.example.moviesapp.common.data.repository

import com.example.moviesapp.common.data.api.ApiConstants
import com.example.moviesapp.common.data.api.api_mapper.castcrewmapper.CreditsMapper
import com.example.moviesapp.common.data.api.api_service.CreditsApiService
import com.example.moviesapp.common.domain.model.castcrew.Credits
import com.example.moviesapp.common.domain.repository.CreditsRepository
import com.example.moviesapp.common.utils.Resource
import javax.inject.Inject

class CreditsRepositoryImpl @Inject constructor(
    private val creditsApiService: CreditsApiService,
    private val creditsMapper: CreditsMapper
):CreditsRepository {
    override suspend fun getCastAndCrew(movieId: Int): Resource<Credits> {
        return try {
            val response = creditsApiService.getCast(movieId,ApiConstants.API_KEY)
            val responseBody = response.body()
            if (response.isSuccessful && responseBody!=null){
                val data = creditsMapper.mapToDomain(responseBody)
                Resource.Success(data)
            }
            else{
                Resource.Error(response.message())
            }
        }catch (e:Exception){
            Resource.Error(e.message)
        }
    }


}