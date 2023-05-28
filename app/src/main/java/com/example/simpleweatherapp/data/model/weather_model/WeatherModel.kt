package com.example.simpleweatherapp.data.model.weather_model

/**
 * This class which is a special class, represents data model of the Weather.
 *
 * @param base Internal parameter
 * @param clouds clouds status
 * @param cod cod status
 * @param coord coord status
 * @param dt time of data calculation
 * @param id city ID
 * @param main main of weather status
 * @param name city name
 * @param rain rain status
 * @param sys sys status (country, id sunrise, sunset, type)
 * @param timezone shift in seconds from UTC
 * @param visibility visibility, meter. The maximum value of the visibility is 10km
 * @param weather list of weather status (description, icon, id, main)
 * @param wind wind status (deg, gust, speed)
 */
data class WeatherModel(
    val base: String,
    val clouds: Clouds,
    val cod: Int,
    val coord: Coord,
    val dt: Int,
    val id: Int,
    val main: Main,
    val name: String,
    val rain: Rain,
    val sys: Sys,
    val timezone: Int,
    val visibility: Int,
    val weather: List<Weather>,
    val wind: Wind
)