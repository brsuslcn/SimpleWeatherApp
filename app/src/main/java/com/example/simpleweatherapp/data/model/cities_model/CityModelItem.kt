package com.example.simpleweatherapp.data.model.cities_model

data class CityModelItem(
    val coord: Coord,
    val country: String,
    val id: Long,
    val name: String,
    val state: String
)