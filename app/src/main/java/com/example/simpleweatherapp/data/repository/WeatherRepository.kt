package com.example.simpleweatherapp.data.repository

import com.example.simpleweatherapp.data.model.weather_model.WeatherModel
import com.example.simpleweatherapp.data.remote.WeatherServices
import retrofit2.Response
import javax.inject.Inject

class WeatherRepository @Inject constructor(private val weatherServices: WeatherServices) {
    suspend fun getWeatherData(apiKey:String, units:String, cityId:String) : Response<WeatherModel>{
        return weatherServices.getWeatherInfo(apiKey,units,cityId)
    }
}