package com.example.moviesapp.common.data.di

import com.example.moviesapp.common.data.api.api_mapper.ApiMapper
import com.example.moviesapp.common.data.api.api_mapper.castcrewmapper.CastMapper
import com.example.moviesapp.common.data.api.api_mapper.castcrewmapper.CreditsMapper
import com.example.moviesapp.common.data.api.api_mapper.castcrewmapper.CrewMapper
import com.example.moviesapp.common.data.api.api_mapper.moviesdetailsmapper.MovieDetailsMapper
import com.example.moviesapp.common.data.api.api_mapper.moviesdetailsmapper.MovieGenreMapper
import com.example.moviesapp.common.data.api.api_mapper.moviesdetailsmapper.ProductionCountryMapper
import com.example.moviesapp.common.data.api.api_mapper.person.PersonDetailsMapper
import com.example.moviesapp.common.data.api.api_mapper.popularmoviesmapper.PopularMoviesListMapper
import com.example.moviesapp.common.data.api.api_mapper.popularmoviesmapper.PopularMoviesMapper
import com.example.moviesapp.common.data.api.api_mapper.popularpeoplemapper.PopularPeopleDetailsMapper
import com.example.moviesapp.common.data.api.api_mapper.popularpeoplemapper.PopularPeopleMapper
import com.example.moviesapp.common.data.api.api_mapper.similarmoviesmapper.SimilarMoviesDetailsMapper
import com.example.moviesapp.common.data.api.api_mapper.similarmoviesmapper.SimilarMoviesMapper
import com.example.moviesapp.common.data.api.api_mapper.topratedmoviesmapper.TopRatedMoviesListMapper
import com.example.moviesapp.common.data.api.api_mapper.topratedmoviesmapper.TopRatedMoviesMapper
import com.example.moviesapp.common.data.api.api_mapper.trailerMapper.TrailerListMapper
import com.example.moviesapp.common.data.api.api_mapper.trailerMapper.TrailerMapper
import com.example.moviesapp.common.data.api.dto.castcrewDto.CastDetailsDto
import com.example.moviesapp.common.data.api.dto.castcrewDto.CreditsDto
import com.example.moviesapp.common.data.api.dto.castcrewDto.CrewDetailsDto
import com.example.moviesapp.common.data.api.dto.moviedetailsDto.GenreDto
import com.example.moviesapp.common.data.api.dto.moviedetailsDto.MovieDetailsDto
import com.example.moviesapp.common.data.api.dto.moviedetailsDto.ProductionCountryDto
import com.example.moviesapp.common.data.api.dto.persondetails.PersonDetailsDto
import com.example.moviesapp.common.data.api.dto.popularmoviesDto.PopularMoviesDetailsDto
import com.example.moviesapp.common.data.api.dto.popularmoviesDto.PopularMoviesDto
import com.example.moviesapp.common.data.api.dto.popularpeopleDto.PopularPeopleDetailsDto
import com.example.moviesapp.common.data.api.dto.popularpeopleDto.PopularPeopleDto
import com.example.moviesapp.common.data.api.dto.similarmoviesDto.SimilarMoviesDetailsDto
import com.example.moviesapp.common.data.api.dto.similarmoviesDto.SimilarMoviesDto
import com.example.moviesapp.common.data.api.dto.topratedmoviesDto.TopRatedMoviesDto
import com.example.moviesapp.common.data.api.dto.topratedmoviesDto.TopRatedMoviesListDto
import com.example.moviesapp.common.data.api.dto.trailerDto.TrailerDto
import com.example.moviesapp.common.data.api.dto.trailerDto.TrailerListDto
import com.example.moviesapp.common.domain.model.castcrew.Cast
import com.example.moviesapp.common.domain.model.castcrew.Credits
import com.example.moviesapp.common.domain.model.castcrew.Crew
import com.example.moviesapp.common.domain.model.moviedetails.Countries
import com.example.moviesapp.common.domain.model.moviedetails.Genre
import com.example.moviesapp.common.domain.model.moviedetails.MovieDetails
import com.example.moviesapp.common.domain.model.persondetails.PersonDetails
import com.example.moviesapp.common.domain.model.popularmovies.PopularMovies
import com.example.moviesapp.common.domain.model.popularmovies.PopularMoviesDetails
import com.example.moviesapp.common.domain.model.popularpeople.PopularPeople
import com.example.moviesapp.common.domain.model.popularpeople.PopularPeopleDetails
import com.example.moviesapp.common.domain.model.similarmovies.SimilarMovies
import com.example.moviesapp.common.domain.model.similarmovies.SimilarMoviesDetails
import com.example.moviesapp.common.domain.model.topratedmovies.TopRatedMovies
import com.example.moviesapp.common.domain.model.topratedmovies.TopRatedMoviesList
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

    @Binds
    fun provideGenreMapper(genreMapper: MovieGenreMapper):ApiMapper<GenreDto,Genre>

    @Binds
    fun provideProductionCountriesMapper(productionCountryMapper: ProductionCountryMapper):ApiMapper<ProductionCountryDto,Countries>

    @Binds
    fun provideCreditsMapper(creditsMapper: CreditsMapper):ApiMapper<CreditsDto,Credits>

    @Binds
    fun provideCastMapper(castMapper: CastMapper):ApiMapper<CastDetailsDto,Cast>

    @Binds
    fun provideCrewMapper(crewMapper: CrewMapper):ApiMapper<CrewDetailsDto,Crew>

    @Binds
    fun provideSimilarMoviesMapper(similarMoviesMapper: SimilarMoviesMapper):ApiMapper<SimilarMoviesDto,SimilarMovies>

    @Binds
    fun provideSimilarMoviesDetailsMapper(similarMoviesDetailsMapper: SimilarMoviesDetailsMapper):ApiMapper<SimilarMoviesDetailsDto,SimilarMoviesDetails>

    @Binds
    fun provideTopRatedMoviesListMapper(topRatedMoviesListMapper: TopRatedMoviesListMapper):ApiMapper<TopRatedMoviesListDto,TopRatedMoviesList>

    @Binds
    fun provideTopRatedMoviesMapper(topRatedMoviesMapper: TopRatedMoviesMapper):ApiMapper<TopRatedMoviesDto, TopRatedMovies>

    @Binds
    fun providePopularPeopleMapper(popularPeopleMapper: PopularPeopleMapper):ApiMapper<PopularPeopleDto,PopularPeople>

    @Binds
    fun providePopularPeopleDetailsMapper(popularPeopleDetailsMapper: PopularPeopleDetailsMapper):ApiMapper<PopularPeopleDetailsDto,PopularPeopleDetails>

    @Binds
    fun providePersonDetailsMapper(personDetailsMapper: PersonDetailsMapper):ApiMapper<PersonDetailsDto,PersonDetails>
}
