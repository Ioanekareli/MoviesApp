package com.example.moviesapp.common.data.repository

import android.util.Log
import com.example.moviesapp.common.data.api.ApiConstants
import com.example.moviesapp.common.data.api.api_mapper.popularpeoplemapper.PopularPeopleMapper
import com.example.moviesapp.common.data.api.api_service.PeopleApiService
import com.example.moviesapp.common.domain.model.popularpeople.PopularPeople
import com.example.moviesapp.common.domain.repository.PopularPeopleRepository
import com.example.moviesapp.common.utils.Resource
import javax.inject.Inject

class PopularPeopleRepositoryImpl @Inject constructor(
    private val popularPeopleApiService: PeopleApiService,
    private val popularPeopleMapper: PopularPeopleMapper
):PopularPeopleRepository {
    override suspend fun getPopularPeople(page: Int): Resource<PopularPeople> {
        return try {
            val response = popularPeopleApiService.getPeople(ApiConstants.API_KEY, page)
            val responseBody = response.body()
            Log.d("repo", "getPopularPeople: ${responseBody?.results} ")
            Log.d("logkata", "getError code: ${response.code()} ")
            if (response.isSuccessful && responseBody != null) {
                val data = popularPeopleMapper.mapToDomain(responseBody)
                Resource.Success(data)
            } else {
                Resource.Error(response.message())
            }
        } catch (e: Exception) {
            Resource.Error(e.message)
        }
    }
}