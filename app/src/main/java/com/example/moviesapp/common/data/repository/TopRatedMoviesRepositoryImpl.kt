package com.example.moviesapp.common.data.repository

import com.example.moviesapp.common.data.api.ApiConstants
import com.example.moviesapp.common.data.api.api_mapper.topratedmoviesmapper.TopRatedMoviesMapper
import com.example.moviesapp.common.data.api.api_service.TopRatedMoviesApiService
import com.example.moviesapp.common.domain.model.topratedmovies.TopRatedMovies
import com.example.moviesapp.common.domain.repository.TopRatedMoviesRepository
import com.example.moviesapp.common.utils.Resource
import javax.inject.Inject

class TopRatedMoviesRepositoryImpl @Inject constructor(
    private val apiService: TopRatedMoviesApiService,
    private val mapper: TopRatedMoviesMapper
):TopRatedMoviesRepository {
    override suspend fun getTopRatedMovies(page:Int): Resource<TopRatedMovies> {
        return try {
            val response = apiService.getTopRatedMovies(ApiConstants.API_KEY,page)
            val responseBody = response.body()
            if (response.isSuccessful && responseBody!= null){
                val data = mapper.mapToDomain(responseBody)
                Resource.Success(data)
            }
            else
                Resource.Error(response.message())
        }catch (e:Exception){
            Resource.Error(e.message)
        }
    }
}