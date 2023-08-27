package com.example.moviesapp.common.data.di

import android.content.Context
import androidx.room.Room
import com.example.moviesapp.common.data.db.AppDataBase
import com.example.moviesapp.common.data.db.dao.MyMoviesDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DataBaseModule {

    @Provides
    fun provideMyMoviesDao(appDataBase: AppDataBase)
    :MyMoviesDao {
        return appDataBase.MyMoviesDao()
    }


    @Provides
    @Singleton
    fun provideDB(
        @ApplicationContext appContext:Context
    ): AppDataBase{
        return Room.databaseBuilder(
            appContext,
            AppDataBase::class.java,
            "movieDb"
        ).build()
    }

}