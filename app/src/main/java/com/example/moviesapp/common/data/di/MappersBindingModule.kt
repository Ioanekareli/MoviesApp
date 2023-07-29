package com.example.moviesapp.common.data.di

import com.example.moviesapp.common.data.api.api_mapper.ApiMapper
import com.example.moviesapp.common.data.api.api_mapper.PopularMoviesListMapper
import com.example.moviesapp.common.data.api.api_mapper.PopularMoviesMapper
import com.example.moviesapp.common.data.api.dto.PopularMoviesDetailsDto
import com.example.moviesapp.common.data.api.dto.PopularMoviesDto
import com.example.moviesapp.common.domain.model.PopularMovies
import com.example.moviesapp.common.domain.model.PopularMoviesDetails
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
interface MappersBindingModule {

    @Binds
    fun providePopularMoviesListMapper(popularMoviesListMapper: PopularMoviesListMapper):ApiMapper<PopularMoviesDetailsDto,PopularMoviesDetails>

    @Binds
    fun providePopularMoviesMapper(popularMoviesMapper: PopularMoviesMapper):ApiMapper<PopularMoviesDto,PopularMovies>

}