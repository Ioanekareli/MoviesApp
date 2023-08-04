package com.example.moviesapp.common.data.repository

import com.example.moviesapp.common.data.api.ApiConstants
import com.example.moviesapp.common.data.api.api_mapper.popularmoviesmapper.PopularMoviesMapper
import com.example.moviesapp.common.data.api.api_service.PopularMoviesApiService
import com.example.moviesapp.common.domain.model.popularmovies.PopularMovies
import com.example.moviesapp.common.domain.repository.PopularMoviesRepository
import com.example.moviesapp.common.utils.Resource
import javax.inject.Inject

class PopularMoviesRepositoryImpl @Inject constructor(
    private val popularMoviesApiService: PopularMoviesApiService,
    private val popularMoviesMapper: PopularMoviesMapper
    ):PopularMoviesRepository {

    override suspend fun getPopularMovies(page: Int): Resource<PopularMovies> {
        return try {
            val response = popularMoviesApiService.getPopularMovies(ApiConstants.API_KEY,page)
            val responseBody = response.body()
            if (response.isSuccessful && responseBody != null){
                val data = popularMoviesMapper.mapToDomain(responseBody)
                Resource.Success(data)
            }else{
                Resource.Error(response.message())
            }
        }
        catch (e:Exception){
            Resource.Error(e.message)
        }
    }
}