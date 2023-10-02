package com.example.moviesapp.common.utils

import android.content.Context
import android.graphics.Paint
import android.graphics.Rect
import android.widget.ImageView
import com.example.moviesapp.R
import com.squareup.picasso.Picasso

fun ImageView.setImage(url: String?) {

    if (!url.isNullOrEmpty()) {
        Picasso.get().load(url).into(this)
    } else {
        setImageResource(R.mipmap.ic_launcher)
    }

}

fun Context.dpToPx(dp: Float) = this.resources.displayMetrics.density * dp

fun Paint.getTextWidth(string: String): Float {
    val rect = Rect()
    this.getTextBounds(string, 0, string.length, rect)
    return rect.width().toFloat()
}