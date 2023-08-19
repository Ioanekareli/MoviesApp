package com.example.moviesapp.common.data.api

object ApiConstants {
    const val BASE_URL = "https://api.themoviedb.org/3/"

    const val POPULAR_MOVIES_ENDPOINT = "movie/popular"
    const val TOP_RATED_MOVIES_ENDPOINT = "movie/top_rated"
    const val PEOPLE_ENDPOINT = "person/popular"
    const val MOVIE_DETAILS_ENDPOINT = "movie/{movie_id}"
    const val TRAILER_ENDPOINT = "movie/{movie_id}/videos"
    const val CAST_ENDPOINT = "movie/{movie_id}/credits"
    const val SIMILAR_MOVIES_ENDPOINT = "movie/{movie_id}/similar"
    const val PERSON_DETAILS_ENDPOINT = "person/{person_id}"

    const val API_KEY = "f0e8fd8310cf03464835a4e517f013df"
    const val IMG_URL = "https://image.tmdb.org/t/p/w500"
}

