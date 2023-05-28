package com.example.simpleweatherapp.util

import android.content.Context
import java.io.File

/**
 * This class manages SharedPreferences file
 *
 * @param context required context in order to access the json file.
 * @property sharedPreferences a property in order to manage sharedpreference file.
 *
 */

class LocalSharedPref (private val context: Context){

    private val sharedPreferences = context.getSharedPreferences("SelectedCity", Context.MODE_PRIVATE)

    /**
     * This function saves the selected city's ID.
     *
     * @param cityId selected city's ID
     */
    fun writeSelectedCity(cityId : String)
    {
        val editor = sharedPreferences.edit()
        editor.putString("selected", cityId)
        editor.apply()
    }

    /**
     * This function reads the selected city's ID.
     *
     * @return cityId as a string.
     */
    fun getSelectedCity() : String?
    {
        return sharedPreferences.getString("selected","nothing")
    }

    /**
     * This function checks if the sharedpreferences file exist.
     *
     * @return boolean
     */
    fun isSharedPreferencesExists(): Boolean {
        val sharedPreferencesFile = File(context.applicationInfo.dataDir, "shared_prefs/SelectedCity.xml")
        return sharedPreferencesFile.exists()
    }
}