package com.example.moviesapp.common.utils

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers

interface DispatchersProvides {

    fun io():CoroutineDispatcher = Dispatchers.IO

}