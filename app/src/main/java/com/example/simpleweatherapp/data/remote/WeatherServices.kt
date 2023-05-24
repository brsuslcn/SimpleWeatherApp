package com.example.simpleweatherapp.data.remote

import com.example.simpleweatherapp.data.model.weather_model.WeatherModel
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherServices {
    @GET("data/2.5/weather")
    suspend fun getWeatherInfo(
        @Query("APPID") apiKey : String,
        @Query("units") units : String,
        @Query("id") cityId : String
    ) : Response<WeatherModel>

}