package com.example.moviesapp.common.data.db.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.moviesapp.common.data.db.entity.mymovies.MyMovieEntity

@Dao
interface MyMoviesDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addMovie(entity:MyMovieEntity)

    @Query("SELECT * FROM my_movies")
    suspend fun getAllMovies():List<MyMovieEntity>

    @Query("DELETE from my_movies WHERE id = :id")
    suspend fun deleteCard(id: Int?)

}
