package com.example.simpleweatherapp.data.di

import android.app.Application
import android.content.Context
import com.google.gson.Gson
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object CitiesModule {
    @Provides
    fun provideGson() : Gson{
        return Gson()
    }

    @Provides
    fun provideContext(application: Application) : Context {
        return application.applicationContext
    }
}