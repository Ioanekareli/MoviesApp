package com.example.moviesapp.common.data.repository

import com.example.moviesapp.common.data.api.ApiConstants
import com.example.moviesapp.common.data.api.api_mapper.person.PersonDetailsMapper
import com.example.moviesapp.common.data.api.api_service.PersonDetailsApiService
import com.example.moviesapp.common.domain.model.persondetails.PersonDetails
import com.example.moviesapp.common.domain.repository.PersonDetailsRepository
import com.example.moviesapp.common.utils.Resource
import javax.inject.Inject

class PersonDetailsRepositoryImpl @Inject constructor(
    private val personDetailsApi:PersonDetailsApiService,
    private val personDetailsMapper: PersonDetailsMapper
):PersonDetailsRepository {
    override suspend fun getPersonDetails(personId: Int): Resource<PersonDetails> {
        return try {
            val response = personDetailsApi.getPersonDetails(
                personId,
                ApiConstants.API_KEY)

            val responseBody = response.body()
            if (response.isSuccessful && responseBody!=null){
                val data = personDetailsMapper.mapToDomain(responseBody)
                Resource.Success(data)
            }else
                Resource.Error(response.message())
        }catch (e:Exception){
            Resource.Error(e.message)
        }
    }

}