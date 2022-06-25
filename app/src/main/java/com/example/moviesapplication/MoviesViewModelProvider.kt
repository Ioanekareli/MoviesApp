package com.example.moviesapplication

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.moviesapplication.repository.MoviesRepository
import com.example.moviesapplication.ui.movieslist.MoviesListViewModel

class MoviesViewModelProvider(
    val moviesRepository: MoviesRepository
):ViewModelProvider.Factory{
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return MoviesListViewModel(moviesRepository) as T
    }
}