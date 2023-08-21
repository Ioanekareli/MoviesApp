package com.example.moviesapp.common.presentation.peopledetails

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.moviesapp.common.data.repository.PersonDetailsRepositoryImpl
import com.example.moviesapp.common.data.repository.PersonMoviesRepositoryImpl
import com.example.moviesapp.common.domain.model.castcrew.Credits
import com.example.moviesapp.common.domain.model.persondetails.PersonDetails
import com.example.moviesapp.common.domain.model.personmovies.PersonMovies
import com.example.moviesapp.common.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PeopleDetailsViewModel @Inject constructor(
    private val personDetailsRepositoryImpl: PersonDetailsRepositoryImpl,
    private val personMoviesRepositoryImpl: PersonMoviesRepositoryImpl
):ViewModel(){

    val personDetails:LiveData<Resource<PersonDetails>> get() = _personDetails
    private val _personDetails = MutableLiveData<Resource<PersonDetails>>()

    val personId:LiveData<Int> get() = _personId
    private val _personId = MutableLiveData<Int>()

    val personMovies:LiveData<Resource<PersonMovies>> get() = _personMovies
    private val _personMovies = MutableLiveData<Resource<PersonMovies>>()

    fun loadPersonDetails(personId:Int){
        viewModelScope.launch {
            _personDetails.value = personDetailsRepositoryImpl.getPersonDetails(personId)
        }
    }

    fun loadPersonMovies(personId:Int){
        viewModelScope.launch {
            _personMovies.value = personMoviesRepositoryImpl.getPersonMovies(personId)
        }
    }

    fun saveId(personId:Int){
        viewModelScope.launch {
            _personId.value = personId
        }
    }

}