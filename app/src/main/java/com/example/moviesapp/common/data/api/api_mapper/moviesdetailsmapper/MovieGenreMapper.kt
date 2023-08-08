package com.example.moviesapp.common.data.api.api_mapper.moviesdetailsmapper

import com.example.moviesapp.common.data.api.api_mapper.ApiMapper
import com.example.moviesapp.common.data.api.api_mapper.MappingException
import com.example.moviesapp.common.data.api.dto.moviedetailsDto.GenreDto
import com.example.moviesapp.common.domain.model.moviedetails.Genre
import javax.inject.Inject

class MovieGenreMapper @Inject constructor():ApiMapper<GenreDto,Genre> {
    override fun mapToDomain(apiEntity: GenreDto): Genre {
        with(apiEntity){
            return Genre(
                id = id?: throw MappingException("Id can not be null"),
                name = name.orEmpty()
            )
        }
    }
}