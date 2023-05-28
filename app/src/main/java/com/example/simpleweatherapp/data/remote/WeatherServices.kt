package com.example.simpleweatherapp.data.remote

import com.example.simpleweatherapp.data.model.weather_model.WeatherModel
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * API service interface for weather information.
 *
 * This interface identifies required API calls in order to get weather information.
 *
 * @see GET
 * @see Query
 * @see Response
 * @see WeatherModel
 */
interface WeatherServices {
    /**
     * An api call to get info for the requested city.
     *
     * @param apiKey the key, in order to access API
     * @param units the unit value
     * @param cityId the id of the requested city.
     * @return WeatherModel a response that contains WeatherModel
     */
    @GET("data/2.5/weather")
    suspend fun getWeatherInfo(
        @Query("APPID") apiKey : String,
        @Query("units") units : String,
        @Query("id") cityId : String
    ) : Response<WeatherModel>
}