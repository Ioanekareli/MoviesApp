package com.example.moviesapp.common.data.di

import com.example.moviesapp.common.data.api.ApiConstants
import com.example.moviesapp.common.data.api.api_service.CreditsApiService
import com.example.moviesapp.common.data.api.api_service.MovieDetailsApiService
import com.example.moviesapp.common.data.api.api_service.PeopleApiService
import com.example.moviesapp.common.data.api.api_service.PersonDetailsApiService
import com.example.moviesapp.common.data.api.api_service.PopularMoviesApiService
import com.example.moviesapp.common.data.api.api_service.SimilarMoviesApiService
import com.example.moviesapp.common.data.api.api_service.TopRatedMoviesApiService
import com.example.moviesapp.common.data.api.api_service.TrailerApiService
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

    @Provides
    @Singleton
    fun movieDetailsApiService():MovieDetailsApiService{
        return Retrofit.Builder()
            .baseUrl(ApiConstants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(MovieDetailsApiService::class.java)
    }

    @Provides
    @Singleton
    fun trailerApiService():TrailerApiService{
        return Retrofit.Builder()
            .baseUrl(ApiConstants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(TrailerApiService::class.java)
    }

    @Provides
    @Singleton
    fun castApiService(): CreditsApiService {
        return Retrofit.Builder()
            .baseUrl(ApiConstants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(CreditsApiService::class.java)
    }

    @Provides
    @Singleton
    fun similarMoviesApiService():SimilarMoviesApiService{
        return Retrofit.Builder()
            .baseUrl(ApiConstants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(SimilarMoviesApiService::class.java)
    }

    @Provides
    @Singleton
    fun topRatedMoviesList():TopRatedMoviesApiService{
        return Retrofit.Builder()
            .baseUrl(ApiConstants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(TopRatedMoviesApiService::class.java)
    }

    @Provides
    @Singleton
    fun popularPeopleApiService():PeopleApiService{
        return Retrofit.Builder()
            .baseUrl(ApiConstants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(PeopleApiService::class.java)
    }

    @Provides
    @Singleton
    fun personDetailsApiService():PersonDetailsApiService{
        return Retrofit.Builder()
            .baseUrl(ApiConstants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(PersonDetailsApiService::class.java)
    }

}