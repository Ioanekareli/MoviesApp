package com.example.moviesapp.common.domain.repository

import com.example.moviesapp.common.domain.model.castcrew.Credits
import com.example.moviesapp.common.utils.Resource

interface CreditsRepository {

    suspend fun getCastAndCrew(movieId:Int): Resource<Credits>

}