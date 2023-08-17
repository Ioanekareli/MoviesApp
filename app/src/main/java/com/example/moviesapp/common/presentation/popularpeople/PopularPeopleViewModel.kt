package com.example.moviesapp.common.presentation.popularpeople

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.moviesapp.common.data.repository.PopularPeopleRepositoryImpl
import com.example.moviesapp.common.domain.model.popularpeople.PopularPeople
import com.example.moviesapp.common.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PopularPeopleViewModel @Inject constructor(
    private val popularPeopleRepositoryImpl: PopularPeopleRepositoryImpl
):ViewModel() {

    val popularPeople:LiveData<Resource<PopularPeople>> get() = _popularPeople
    private val _popularPeople = MutableLiveData<Resource<PopularPeople>>()

    fun loadPopularPeople(){
        viewModelScope.launch {
            _popularPeople.value = popularPeopleRepositoryImpl.getPopularPeople(1)
        }
    }

}