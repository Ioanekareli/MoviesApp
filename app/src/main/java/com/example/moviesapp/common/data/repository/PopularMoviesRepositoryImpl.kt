package com.example.moviesapp.common.data.repository

import com.example.moviesapp.common.data.api.api_mapper.PopularMoviesMapper
import com.example.moviesapp.common.data.api.api_service.PopularMoviesApiService
import com.example.moviesapp.common.domain.model.PopularMovies
import com.example.moviesapp.common.domain.repository.PopularMoviesRepository
import javax.inject.Inject

class PopularMoviesRepositoryImpl @Inject constructor(
    private val popularMoviesApiService: PopularMoviesApiService,
    private val popularMoviesMapper: PopularMoviesMapper
    ):PopularMoviesRepository {

    override suspend fun getPopularMovies(apiKey: String, page: Int): PopularMovies {
        return popularMoviesMapper.mapToDomain(
            popularMoviesApiService.getPopularMovies(apiKey, page)
        )
    }
}