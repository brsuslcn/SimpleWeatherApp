package com.example.simpleweatherapp.data.di

import com.example.simpleweatherapp.data.remote.WeatherServices
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class WeatherModule {
    @Provides
    @Singleton

    fun provideRetrofit() : Retrofit =
        Retrofit.Builder()
            .baseUrl("https://api.openweathermap.org")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

    @Provides
    @Singleton
    fun provideWeatherService(retrofit: Retrofit) : WeatherServices = retrofit.create(WeatherServices::class.java)
}