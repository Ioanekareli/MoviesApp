package com.example.moviesapp.common.presentation.peopledetails.bio

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.moviesapp.common.data.repository.PersonDetailsRepositoryImpl
import com.example.moviesapp.common.domain.model.persondetails.PersonDetails
import com.example.moviesapp.common.utils.Resource
import kotlinx.coroutines.launch
import javax.inject.Inject

class BioFragmentViewModel @Inject constructor(
    private val personDetailsRepositoryImpl: PersonDetailsRepositoryImpl
):ViewModel(){

    val personDetails: LiveData<Resource<PersonDetails>> get() = _personDetails
    private val _personDetails = MutableLiveData<Resource<PersonDetails>>()

    fun loadPersonDetails(personId:Int){
        viewModelScope.launch {
            _personDetails.value = personDetailsRepositoryImpl.getPersonDetails(personId)
        }
    }

}