package com.example.moviesapplication.utils

sealed class Resource<out T>(val data: T? = null , val message: String? = null, val loading: Boolean = false) {

    class Success<T>(data: T) : Resource<T>(data = data)

    class Error<T>(message: String? = null, data: T? = null) : Resource<T>(data = data, message = message)

    class Loading<T>(loading: Boolean) : Resource<T>(loading = loading)

    object Idle: Resource<Nothing>()

}