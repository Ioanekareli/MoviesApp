package com.example.moviesapp.common.data.di

import com.example.moviesapp.common.data.api.ApiConstants
import com.example.moviesapp.common.data.api.api_service.PopularMoviesApiService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object ApiModule{

    @Provides
    @Singleton
    fun providePopularMoviesApi(): PopularMoviesApiService {
        return Retrofit.Builder()
            .baseUrl(ApiConstants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(PopularMoviesApiService::class.java)
    }

}