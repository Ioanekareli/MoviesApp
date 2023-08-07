package com.example.moviesapp.common.data.repository

import com.example.moviesapp.common.data.api.ApiConstants
import com.example.moviesapp.common.data.api.api_mapper.trailerMapper.TrailerMapper
import com.example.moviesapp.common.data.api.api_service.TrailerApiService
import com.example.moviesapp.common.domain.model.trailer.Trailer
import com.example.moviesapp.common.domain.repository.TrailerRepository
import com.example.moviesapp.common.utils.Resource
import javax.inject.Inject

class TrailerRepositoryImpl @Inject constructor(
    private val trailerApiService: TrailerApiService,
    private val trailerMapper: TrailerMapper
):TrailerRepository {
    override suspend fun getTrailer(movieId: Int): Resource<Trailer> {
        return try {
            val response = trailerApiService.getMovieTrailer(
                apiKey = ApiConstants.API_KEY,
                movieId = movieId
            )
            val responseBody = response.body()
            if (response.isSuccessful && responseBody != null){
                val data = trailerMapper.mapToDomain(responseBody)
                Resource.Success(data)
            }else{
                Resource.Error(response.message())
            }
        }catch (e:Exception){
            Resource.Error(e.message)
        }
    }
}