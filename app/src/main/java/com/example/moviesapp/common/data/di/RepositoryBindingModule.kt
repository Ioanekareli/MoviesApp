package com.example.moviesapp.common.data.di

import com.example.moviesapp.common.data.repository.CreditsRepositoryImpl
import com.example.moviesapp.common.data.repository.MovieDetailsRepositoryImpl
import com.example.moviesapp.common.data.repository.MoviePostersRepositoryImpl
import com.example.moviesapp.common.data.repository.MyMoviesRepositoryImpl
import com.example.moviesapp.common.data.repository.PersonDetailsRepositoryImpl
import com.example.moviesapp.common.data.repository.PersonMoviesRepositoryImpl
import com.example.moviesapp.common.data.repository.PopularMoviesRepositoryImpl
import com.example.moviesapp.common.data.repository.PopularPeopleRepositoryImpl
import com.example.moviesapp.common.data.repository.SimilarMoviesRepositoryImpl
import com.example.moviesapp.common.data.repository.TopRatedMoviesRepositoryImpl
import com.example.moviesapp.common.domain.repository.CreditsRepository
import com.example.moviesapp.common.domain.repository.MovieDetailsRepository
import com.example.moviesapp.common.domain.repository.MoviePostersRepository
import com.example.moviesapp.common.domain.repository.MyMoviesRepository
import com.example.moviesapp.common.domain.repository.PersonDetailsRepository
import com.example.moviesapp.common.domain.repository.PersonMoviesRepository
import com.example.moviesapp.common.domain.repository.PopularMoviesRepository
import com.example.moviesapp.common.domain.repository.PopularPeopleRepository
import com.example.moviesapp.common.domain.repository.SimilarMoviesRepository
import com.example.moviesapp.common.domain.repository.TopRatedMoviesRepository
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

    @Binds
    abstract fun bindSimilarMoviesRepository(similarMoviesRepositoryImpl: SimilarMoviesRepositoryImpl):SimilarMoviesRepository

    @Binds
    abstract fun bindTopRatedMoviesRepository(topRatedMoviesRepositoryImpl: TopRatedMoviesRepositoryImpl):TopRatedMoviesRepository

    @Binds
    abstract fun bindPopularPeopleRepository(popularPeopleRepositoryImpl: PopularPeopleRepositoryImpl):PopularPeopleRepository

    @Binds
    abstract fun bindPersonDetailsRepository(personDetailsRepositoryImpl: PersonDetailsRepositoryImpl):PersonDetailsRepository

    @Binds
    abstract fun bindPersonMoviesRepository(personMoviesRepositoryImpl: PersonMoviesRepositoryImpl):PersonMoviesRepository

    @Binds
    abstract fun bindMoviePosterRepositoryImpl(moviePostersRepositoryImpl: MoviePostersRepositoryImpl):MoviePostersRepository

    @Binds
    abstract fun bindMyMoviesRepositoryImpl(myMoviesRepositoryImpl: MyMoviesRepositoryImpl):MyMoviesRepository

}