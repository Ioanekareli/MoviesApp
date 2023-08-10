package com.example.moviesapp.common.data.repository

import com.example.moviesapp.common.data.api.ApiConstants
import com.example.moviesapp.common.data.api.api_mapper.similarmoviesmapper.SimilarMoviesMapper
import com.example.moviesapp.common.data.api.api_service.SimilarMoviesApiService
import com.example.moviesapp.common.domain.model.similarmovies.SimilarMovies
import com.example.moviesapp.common.domain.repository.SimilarMoviesRepository
import com.example.moviesapp.common.utils.Resource
import javax.inject.Inject

class  SimilarMoviesRepositoryImpl @Inject constructor(
    private val similarMoviesApiService: SimilarMoviesApiService,
    private val similarMoviesMapper: SimilarMoviesMapper
):SimilarMoviesRepository {
    override suspend fun getSimilarMovies(movieId: Int): Resource<SimilarMovies> {
        return try {
            val response = similarMoviesApiService.getSimilarMovies(
                movieId = movieId,
                apiKey = ApiConstants.API_KEY)
            val responseBody = response.body()
            if(response.isSuccessful && responseBody!=null){
                val data = similarMoviesMapper.mapToDomain(responseBody)
                Resource.Success(data)
            }else{
                Resource.Error(response.message())
            }
        }catch (e:Exception){
            Resource.Error(e.message)
        }
    }
}