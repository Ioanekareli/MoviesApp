package com.example.moviesapp.common.data.db.entity.mymovies

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "my_movies")
data class MyMovieEntity(
    @PrimaryKey(autoGenerate = true)
    val id:Int,
    @ColumnInfo(name = "poster_path")
    val posterPath:String?,
    val rating:Float?
){
    companion object{
        fun fromDomain(
            movieId:Int,
            poster:String,
            rating: Float?
        ): MyMovieEntity {
            return MyMovieEntity(
                id = movieId,
                posterPath = poster.orEmpty(),
                rating = rating ?: 0f
            )
        }
    }

}
