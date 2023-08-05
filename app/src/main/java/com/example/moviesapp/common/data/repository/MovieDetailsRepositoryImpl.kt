package com.example.moviesapp.common.data.repository

import com.example.moviesapp.common.data.api.ApiConstants
import com.example.moviesapp.common.data.api.api_mapper.moviesdetailsmapper.MovieDetailsMapper
import com.example.moviesapp.common.data.api.api_service.MovieDetailsApiService
import com.example.moviesapp.common.domain.model.moviedetails.MovieDetails
import com.example.moviesapp.common.domain.repository.MovieDetailsRepository
import com.example.moviesapp.common.utils.Resource
import javax.inject.Inject

class MovieDetailsRepositoryImpl @Inject constructor(
    private val movieDetailsApiService: MovieDetailsApiService,
    private val movieDetailsMapper: MovieDetailsMapper
    ):MovieDetailsRepository {
    override suspend fun getMovieDetails(movieId: Int): Resource<MovieDetails> {
        return try {
            val response = movieDetailsApiService.getMovieDetails(
                apiKey = ApiConstants.API_KEY,
                movieId = movieId
            )
            val responseBody = response.body()
            if (response.isSuccessful && responseBody != null){
                val data = movieDetailsMapper.mapToDomain(responseBody)
                Resource.Success(data)
            }else{
                Resource.Error(response.message())
            }
        }catch (e:Exception){
            Resource.Error(e.message)
        }
    }


}