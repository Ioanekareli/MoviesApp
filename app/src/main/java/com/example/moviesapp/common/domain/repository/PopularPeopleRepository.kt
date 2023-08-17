package com.example.moviesapp.common.domain.repository

import com.example.moviesapp.common.domain.model.popularpeople.PopularPeople
import com.example.moviesapp.common.utils.Resource

interface PopularPeopleRepository {

    suspend fun getPopularPeople(page:Int):Resource<PopularPeople>

}