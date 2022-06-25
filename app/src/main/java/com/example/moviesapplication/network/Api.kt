package com.example.moviesapplication.network

import com.example.moviesapplication.dto.TopRatedMovieList
import com.example.moviesapplication.videosdto.MovieTrailers
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface Api {

    @GET("/3/movie/top_rated")
    suspend fun getMovieList(
        @Query("api_key") apiKey:String
    ):Response<TopRatedMovieList>

    @GET("/3/movie/{movie_id}/videos")
    suspend fun getMovieTrailer(
        @Path("movie_id")id:String,
        @Query("api_key") apiKey: String
    ):Response<MovieTrailers>

}
