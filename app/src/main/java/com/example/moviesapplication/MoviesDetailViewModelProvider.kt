package com.example.moviesapplication

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.moviesapplication.repository.MoviesRepository
import com.example.moviesapplication.ui.moviesdetail.MovieDetailViewModel

class MoviesDetailViewModelProvider(
    val moviesRepository: MoviesRepository
): ViewModelProvider.Factory{
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return MovieDetailViewModel(moviesRepository) as T
    }
}