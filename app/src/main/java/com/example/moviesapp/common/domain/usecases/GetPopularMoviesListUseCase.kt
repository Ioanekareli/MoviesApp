package com.example.moviesapp.common.domain.usecases

import android.util.Log
import com.example.moviesapp.common.domain.NoMoreMoviesException
import com.example.moviesapp.common.domain.repository.PopularMoviesRepository
import javax.inject.Inject

class GetPopularMoviesListUseCase @Inject constructor(
    private val popularMoviesRepository: PopularMoviesRepository
) {

    suspend operator fun invoke(
        apiKey:String,
        page:Int
    ){
        val movies = popularMoviesRepository.getPopularMovies(apiKey,page)
        Log.d("logkata", "invoke: $movies")
        if (movies.results.isEmpty()){
            throw NoMoreMoviesException("There is no movies")
        }

    }

}