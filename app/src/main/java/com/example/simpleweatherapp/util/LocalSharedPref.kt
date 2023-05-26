package com.example.simpleweatherapp.util

import android.content.Context
import java.io.File

class LocalSharedPref (private val context: Context){

    private val sharedPreferences = context.getSharedPreferences("SelectedCity", Context.MODE_PRIVATE)

    fun writeSelectedCity(cityId : String)
    {
        val editor = sharedPreferences.edit()
        editor.putString("selected", cityId)
        editor.apply()
    }

    fun getSelectedCity() : String?
    {
        return sharedPreferences.getString("selected","nothing")
    }


    fun isSharedPreferencesExists(): Boolean {
        val sharedPreferencesFile = File(context.applicationInfo.dataDir, "shared_prefs/SelectedCity.xml")
        return sharedPreferencesFile.exists()
    }
}