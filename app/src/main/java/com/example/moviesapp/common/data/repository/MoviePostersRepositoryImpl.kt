package com.example.moviesapp.common.data.repository

import com.example.moviesapp.common.data.api.ApiConstants
import com.example.moviesapp.common.data.api.api_mapper.moviepostersmapper.MoviePostersMapper
import com.example.moviesapp.common.data.api.api_service.MoviePosterApiService
import com.example.moviesapp.common.domain.model.movieposters.MoviePosters
import com.example.moviesapp.common.domain.repository.MoviePostersRepository
import com.example.moviesapp.common.utils.Resource
import javax.inject.Inject

class MoviePostersRepositoryImpl @Inject constructor(
    private val moviePosterApiService: MoviePosterApiService,
    private val moviePostersMapper: MoviePostersMapper
):MoviePostersRepository{
    override suspend fun getPosters(movieId: Int): Resource<MoviePosters> {
        return try {
            val response = moviePosterApiService.getMoviePosters(movieId,ApiConstants.API_KEY)
            val responseBody = response.body()
            if (response.isSuccessful && responseBody != null){
                val data = moviePostersMapper.mapToDomain(responseBody)
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