package com.example.simpleweatherapp.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.simpleweatherapp.data.model.weather_model.WeatherModel
import com.example.simpleweatherapp.data.repository.WeatherRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class WeatherViewModel @Inject constructor(private val weatherRepository: WeatherRepository) : ViewModel(){
    private val _weatherLiveData = MutableLiveData<WeatherModel>()
    val weatherLiveData : LiveData<WeatherModel> get() = _weatherLiveData

    val API_KEY = "d22707cbafd11ff9c0b31090a56c8c9a"
    val units="metric"


    fun weatherStatus(cityId:String)
    {
        viewModelScope.launch {
            val response = weatherRepository.getWeatherData(API_KEY,units,cityId)
            val weatherItems : WeatherModel? = response.body()
            _weatherLiveData.value = weatherItems!!


           // Log.e("Response",response.body().toString())

        }
    }


}