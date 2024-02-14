package com.example.moviesapp.common.utils

interface Downloader {

    fun downloadFile(url:String): Long

}