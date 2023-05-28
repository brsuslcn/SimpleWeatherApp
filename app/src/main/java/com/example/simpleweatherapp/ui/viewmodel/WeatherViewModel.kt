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

/**
 * This class is a viewModel class of WeatherFragment.
 * It is a viewModel class used to fetch data into WeatherFragment.
 * This class acts as an intermediary between the model (data and business logic) and the view (UI elements)
 *
 * @param weatherRepository WeatheRepository object (injected by Hilt)
 * @property _weatherLiveData keeps the data from the API and sends it to weatherLiveData
 * @property weatherLiveData keeps all the data from the API and it is used in order to access from another classes.
 * @property API_KEY mandatory API Key
 * @property unit the unit of the API
 * @constructor supplies dependency injection for the object of WeatherRepository.
 *
 * @see HiltViewModel
 */
@HiltViewModel
class WeatherViewModel @Inject constructor(private val weatherRepository: WeatherRepository) : ViewModel(){
    private val _weatherLiveData = MutableLiveData<WeatherModel>()
    val weatherLiveData : LiveData<WeatherModel> get() = _weatherLiveData

    val API_KEY = "d22707cbafd11ff9c0b31090a56c8c9a"
    val units="metric"

    /**
     * This function fetchs weather data and send to UI for requested city.
     * @param cityId requested city's ID
     *
     * @see viewModelScope
     */
    fun weatherStatus(cityId:String)
    {
        viewModelScope.launch {
            val response = weatherRepository.getWeatherData(API_KEY,units,cityId)
            val weatherItems : WeatherModel? = response.body()
            _weatherLiveData.value = weatherItems!!
        }
    }


}