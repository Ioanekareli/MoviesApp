package com.example.moviesapp.common.data.di

import com.example.moviesapp.common.data.api.api_mapper.ApiMapper
import com.example.moviesapp.common.data.api.api_mapper.moviesdetailsmapper.MovieDetailsMapper
import com.example.moviesapp.common.data.api.api_mapper.popularmoviesmapper.PopularMoviesListMapper
import com.example.moviesapp.common.data.api.api_mapper.popularmoviesmapper.PopularMoviesMapper
import com.example.moviesapp.common.data.api.api_mapper.trailerMapper.TrailerListMapper
import com.example.moviesapp.common.data.api.api_mapper.trailerMapper.TrailerMapper
import com.example.moviesapp.common.data.api.dto.moviedetailsDto.MovieDetailsDto
import com.example.moviesapp.common.data.api.dto.popularmoviesDto.PopularMoviesDetailsDto
import com.example.moviesapp.common.data.api.dto.popularmoviesDto.PopularMoviesDto
import com.example.moviesapp.common.data.api.dto.trailerDto.TrailerDto
import com.example.moviesapp.common.data.api.dto.trailerDto.TrailerListDto
import com.example.moviesapp.common.domain.model.moviedetails.MovieDetails
import com.example.moviesapp.common.domain.model.popularmovies.PopularMovies
import com.example.moviesapp.common.domain.model.popularmovies.PopularMoviesDetails
import com.example.moviesapp.common.domain.model.trailer.Trailer
import com.example.moviesapp.common.domain.model.trailer.TrailerList
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
interface MappersBindingModule {

    @Binds
    fun providePopularMoviesListMapper(popularMoviesListMapper: PopularMoviesListMapper):ApiMapper<PopularMoviesDetailsDto, PopularMoviesDetails>

    @Binds
    fun providePopularMoviesMapper(popularMoviesMapper: PopularMoviesMapper):ApiMapper<PopularMoviesDto, PopularMovies>

    @Binds
    fun provideMovieDetailsMapper(movieDetailsMapper:MovieDetailsMapper):ApiMapper<MovieDetailsDto,MovieDetails>

    @Binds
    fun provideTrailerMapper(trailerMapper:TrailerMapper):ApiMapper<TrailerDto,Trailer>

    @Binds
    fun provideTrailerListMapper(trailerListMapper:TrailerListMapper):ApiMapper<TrailerListDto,TrailerList>

}