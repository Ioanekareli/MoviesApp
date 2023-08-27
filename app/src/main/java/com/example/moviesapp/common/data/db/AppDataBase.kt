package com.example.moviesapp.common.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.moviesapp.common.data.db.dao.MyMoviesDao
import com.example.moviesapp.common.data.db.entity.mymovies.MyMovieEntity

@Database(entities = [MyMovieEntity::class], version = 1)
abstract class AppDataBase:RoomDatabase(){
    abstract fun MyMoviesDao():MyMoviesDao
}
