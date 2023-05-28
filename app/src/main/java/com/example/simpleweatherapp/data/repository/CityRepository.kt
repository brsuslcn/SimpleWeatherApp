package com.example.simpleweatherapp.data.repository


import android.content.Context
import com.example.simpleweatherapp.data.model.cities_model.CityModel
import com.example.simpleweatherapp.data.model.cities_model.CityModelItem
import com.google.gson.Gson
import java.io.BufferedReader
import java.io.InputStreamReader
import javax.inject.Inject

/**
 * The data of the cities is being fetched by this repository class.
 *
 * This class reads the city data and turns into a CityModelItem list.
 * While turning to JSON, GSON library is being used and by context object, accessing the file.
 *
 * @param gson Gson object
 * @param context a Context object
 * @constructor The constructor used for dependency injection to obtain Gson and Context objects
 */

class CityRepository @Inject constructor(private val gson : Gson, private val context : Context) {
    /**
     * The fucntion reads all the data of cities and turns into CityModelItem.
     *
     * @param fileName the name of JSON file.
     * @return the list of CityModelItem
     */
    fun getCitiesFromJsonFile(fileName:String) : List<CityModelItem>{
        val inputStream = context.assets.open(fileName)
        val reader = BufferedReader(InputStreamReader(inputStream))
        val jsonString = reader.use{it.readText()}
        return gson.fromJson(jsonString, CityModel::class.java)
    }
}