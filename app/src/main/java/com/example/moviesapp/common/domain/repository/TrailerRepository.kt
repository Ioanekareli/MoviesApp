package com.example.moviesapp.common.domain.repository

import com.example.moviesapp.common.domain.model.trailer.Trailer
import com.example.moviesapp.common.utils.Resource

interface TrailerRepository {

    suspend fun getTrailer(movieId:Int): Resource<Trailer>

}