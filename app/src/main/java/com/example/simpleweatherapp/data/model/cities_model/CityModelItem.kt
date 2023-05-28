package com.example.simpleweatherapp.data.model.cities_model

/**
 * This data class represents the city data.
 *
 * @param coord the coordinates of the city
 * @param country the country of the city
 * @param id the id of the city
 * @param name the name of the city
 * @param state the state of the city
 */

data class CityModelItem(
    val coord: Coord,
    val country: String,
    val id: Long,
    val name: String,
    val state: String
)