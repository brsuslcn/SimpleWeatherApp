package com.example.simpleweatherapp.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.simpleweatherapp.data.model.cities_model.CityModelItem
import com.example.simpleweatherapp.data.repository.CityRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject


@HiltViewModel
class SelectionViewModel @Inject constructor(private val cityRepository: CityRepository) : ViewModel() {
    companion object {
        private var _cityModel: List<CityModelItem>? = null
    }

    val cityLiveData: LiveData<List<CityModelItem>>
        get() = MutableLiveData<List<CityModelItem>>().apply {
            value = _cityModel
        }

    fun getCities(fileName: String) {
        _cityModel = cityRepository.getCitiesFromJsonFile(fileName)
    }

}