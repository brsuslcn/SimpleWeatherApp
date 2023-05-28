package com.example.simpleweatherapp.data.repository

import com.example.simpleweatherapp.data.model.weather_model.WeatherModel
import com.example.simpleweatherapp.data.remote.WeatherServices
import retrofit2.Response
import javax.inject.Inject

/**
 * This class supplies to access WeatherServices
 *
 * This class is used to access city data through Weather API Services
 *
 * @param weatherServices Weather API Services.
 */
class WeatherRepository @Inject constructor(private val weatherServices: WeatherServices) {
    /**
     * In order to acess the data of the requested city, executes the Weather API call
     *
     * @param apiKey the key of the Weather API Service
     * @param units the unit of the API call
     * @param cityId the id of the requested city
     *
     * @return A response that contains weather info as WeatherModel for the requested city
     */
    suspend fun getWeatherData(apiKey:String, units:String, cityId:String) : Response<WeatherModel>{
        return weatherServices.getWeatherInfo(apiKey,units,cityId)
    }
}