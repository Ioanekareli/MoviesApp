package com.example.moviesapp.common.domain.repository

import com.example.moviesapp.common.domain.model.persondetails.PersonDetails
import com.example.moviesapp.common.utils.Resource

interface PersonDetailsRepository {

    suspend fun getPersonDetails(personId:Int): Resource<PersonDetails>

}