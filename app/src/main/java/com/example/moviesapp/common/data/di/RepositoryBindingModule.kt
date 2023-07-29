package com.example.moviesapp.common.data.di

import com.example.moviesapp.common.data.repository.PopularMoviesRepositoryImpl
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

}