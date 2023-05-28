package com.example.simpleweatherapp.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.simpleweatherapp.data.model.cities_model.CityModelItem
import com.example.simpleweatherapp.data.repository.CityRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

/**
 * This class is a viewModel class of SelectionFragment.
 * It is a viewModel class used to fetch data into SelectionFragment.
 * This class acts as an intermediary between the model (data and business logic) and the view (UI elements)
 *
 * @param cityRepository CityRepository object (injected by Hilt)
 * @property cityModelTmp keeps cities data from the json file at the memory temporarily (like a cache) during the application runs.
 * @property cityLiveData it can be used in order to access all cities data from another classes.
 * @constructor supplies the dependency injection for the object of CityRepository
 *
 * @see HiltViewModel
 * @see Inject
 */
@HiltViewModel
class SelectionViewModel @Inject constructor(private val cityRepository: CityRepository) : ViewModel() {
    companion object {
        private var cityModelTmp: List<CityModelItem>? = null
    }

    val cityLiveData: LiveData<List<CityModelItem>>
        get() = MutableLiveData<List<CityModelItem>>().apply {
            value = cityModelTmp
        }

    /**
     * This function gets all the cities from jsonFile via cityRepository.
     *
     * @param fileName the name of JsonFile.
     */
    fun getCities(fileName: String) {
        cityModelTmp = cityRepository.getCitiesFromJsonFile(fileName)
    }
}