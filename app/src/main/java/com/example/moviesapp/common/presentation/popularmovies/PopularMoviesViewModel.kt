package com.example.moviesapp.common.presentation.popularmovies

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.moviesapp.common.domain.NetworkException
import com.example.moviesapp.common.domain.NetworkUnavailableException
import com.example.moviesapp.common.domain.usecases.GetPopularMoviesListUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import java.io.IOException
import javax.inject.Inject

@HiltViewModel
class PopularMoviesViewModel @Inject constructor(
    private val popularMoviesListUseCase: GetPopularMoviesListUseCase
): ViewModel() {

    val state:LiveData<PopularMoviesViewState> get() = _state
    private var _state = MutableLiveData<PopularMoviesViewState>()

    var isLoadingMoreMovies: Boolean = false
        private set

    init {
        _state.value = PopularMoviesViewState()
    }

    fun onEvent(event: PopularMoviesEvent,apiKey: String,page: Int){
        when(event){
            is PopularMoviesEvent.RequestPopularMoviesList -> loadPopularMovies(apiKey,page)
            is PopularMoviesEvent.RequestMorePopularMovies -> loadMoreMovies(apiKey,page)
        }
    }

    private fun loadPopularMovies(apiKey:String,page:Int){
        if (state.value!!.popularMovies.isEmpty()){
            loadMoreMovies(apiKey,page)
        }
    }

    private fun loadMoreMovies(apiKey:String,page:Int){
        Log.d("logkata", "loadPopularMovies: ${state.value} ")
        isLoadingMoreMovies = true
        viewModelScope.launch {
            popularMoviesListUseCase.invoke(apiKey,page)
            isLoadingMoreMovies = false
        }
    }

//    private fun onFailure(failure:Throwable){
//        when(failure){
//            is NetworkException,
//            is NetworkUnavailableException -> {
//                _state.value = state.value!!.copy(
//                    loading = false,
//                    failure = IOException(failure)
//                )
//            }
//        }
//    }

}