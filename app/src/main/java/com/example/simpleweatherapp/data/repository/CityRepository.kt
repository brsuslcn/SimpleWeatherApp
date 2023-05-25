package com.example.simpleweatherapp.data.repository


import android.content.Context
import com.example.simpleweatherapp.data.model.cities_model.CityModel
import com.example.simpleweatherapp.data.model.cities_model.CityModelItem
import com.google.gson.Gson
import java.io.BufferedReader
import java.io.InputStreamReader
import javax.inject.Inject

class CityRepository @Inject constructor(private val gson : Gson, private val context : Context) {
    fun getCitiesFromJsonFile(fileName:String) : List<CityModelItem>{
        val inputStream = context.assets.open(fileName)
        val reader = BufferedReader(InputStreamReader(inputStream))
        val jsonString = reader.use{it.readText()}
        return gson.fromJson(jsonString, CityModel::class.java)
    }
}