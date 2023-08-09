package com.example.moviesapp.common.data.di

import com.example.moviesapp.common.data.repository.CreditsRepositoryImpl
import com.example.moviesapp.common.data.repository.MovieDetailsRepositoryImpl
import com.example.moviesapp.common.data.repository.PopularMoviesRepositoryImpl
import com.example.moviesapp.common.domain.repository.CreditsRepository
import com.example.moviesapp.common.domain.repository.MovieDetailsRepository
import com.example.moviesapp.common.domain.repository.PopularMoviesRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryBindingModule {

    @Binds
    abstract fun bindPopularMoviesRepository(popularMoviesRepositoryImpl: PopularMoviesRepositoryImpl):PopularMoviesRepository

    @Binds
    abstract fun bindMovieDetailsRepository(movieDetailsRepositoryImpl: MovieDetailsRepositoryImpl):MovieDetailsRepository

    @Binds
    abstract fun bindCreditsRepository(creditsRepositoryImpl: CreditsRepositoryImpl):CreditsRepository

}