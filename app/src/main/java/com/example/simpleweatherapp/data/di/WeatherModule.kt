package com.example.simpleweatherapp.data.di

import com.example.simpleweatherapp.data.remote.WeatherServices
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

/**
 * This module class is also managed by Hilt
 *
 * This class is used by Hilt for dependency injection and supplies basic dependencies of the application.
 * The retrofit object is used to provide the necessary service dependencies.
 *
 * @see Module
 * @see InstallIn
 * @see SingletonComponent
 * @see Provides
 * @see Singleton
 */
@Module
@InstallIn(SingletonComponent::class)
class WeatherModule {

    /**
     * This function supplies the retrofit object.
     *
     * It cretes the retrofit object and configure all required settings.
     *
     * @return the retrofit object
     *
     */
    @Provides
    @Singleton
    fun provideRetrofit() : Retrofit =
        Retrofit.Builder()
            .baseUrl("https://api.openweathermap.org")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

    /**
     * The fuction named provideWeatherService supplies the dependency of api service.
     *
     * This function takes the Retrofit object as a parameter and creates the WeatherServices (Api Service) interface based on it
     *
     * @param retrofit Retrofit object
     * @return the dependency of WeatherService
     */
    @Provides
    @Singleton
    fun provideWeatherService(retrofit: Retrofit) : WeatherServices = retrofit.create(WeatherServices::class.java)
}