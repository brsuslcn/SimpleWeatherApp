package com.example.simpleweatherapp.data.di

import android.app.Application
import android.content.Context
import com.google.gson.Gson
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

/**
 * This module class is managed by Hilt
 *
 * This class is used by Hilt for dependency injection and supplies basic dependencies of the application.
 * The dependencies of Gson and Context are supplied by this module.
 *
 * @see Module
 * @see InstallIn
 * @see SingletonComponent
 * @see Provides
 */
@Module
@InstallIn(SingletonComponent::class)
object CitiesModule {

    /**
     * The function supplies Gson object.
     */
    @Provides
    fun provideGson() : Gson{
        return Gson()
    }

    /**
     * The function supplies Context object.
     *
     * @param application Application object
     * @return context
     */
    @Provides
    fun provideContext(application: Application) : Context {
        return application.applicationContext
    }
}