package com.example.moviesapplication.utils

import android.widget.ImageView
import com.bumptech.glide.Glide
import com.example.moviesapplication.R

fun ImageView.setImage(url: String?) {

    if (!url.isNullOrEmpty()) {
        Glide.with(this).load("https://image.tmdb.org/t/p/original/$url").placeholder(R.mipmap.ic_launcher)
            .into(this)
    } else {
        setImageResource(R.mipmap.ic_launcher)
    }
}