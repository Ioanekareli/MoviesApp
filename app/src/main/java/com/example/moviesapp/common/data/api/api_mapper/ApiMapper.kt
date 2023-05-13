package com.example.moviesapp.common.data.api.api_mapper

interface ApiMapper<E,D> {

    fun mapToDomain(apiEntity:E):D

    fun mapListToDomain(apiEntity:List<E>):List<D>{
        return apiEntity.map { entity ->
            mapToDomain(entity) }
    }
}