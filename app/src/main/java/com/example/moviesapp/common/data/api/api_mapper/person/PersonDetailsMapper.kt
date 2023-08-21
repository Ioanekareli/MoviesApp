package com.example.moviesapp.common.data.api.api_mapper.person

import com.example.moviesapp.common.data.api.api_mapper.ApiMapper
import com.example.moviesapp.common.data.api.api_mapper.MappingException
import com.example.moviesapp.common.data.api.dto.persondetails.PersonDetailsDto
import com.example.moviesapp.common.domain.model.persondetails.PersonDetails
import javax.inject.Inject

class PersonDetailsMapper @Inject constructor()
    :ApiMapper<PersonDetailsDto,PersonDetails> {
    override fun mapToDomain(apiEntity: PersonDetailsDto): PersonDetails {
        with(apiEntity){
            return PersonDetails(
                id = id?: throw MappingException("Id can not be null"),
                biography = biography.orEmpty(),
                birthday = birthday.orEmpty(),
                deathDay = deathDay.orEmpty(),
                knownFor = knownForDepartment.orEmpty(),
                name = name.orEmpty(),
                profile = profilePath.orEmpty()
            )
        }
    }

}