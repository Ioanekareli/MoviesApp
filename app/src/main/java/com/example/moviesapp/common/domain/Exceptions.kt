package com.example.moviesapp.common.domain

import okio.IOException

class NoMoreMoviesException(message:String):Exception(message)

class NetworkUnavailableException(message: String = NO_NETWORK_AVAILABLE):IOException(message)

class NetworkException(message: String):Exception(message)

const val NO_NETWORK_AVAILABLE = "No network Available"