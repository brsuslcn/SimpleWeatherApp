package com.example.simpleweatherapp.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.example.simpleweatherapp.R
import com.example.simpleweatherapp.databinding.FragmentWeatherBinding
import com.example.simpleweatherapp.ui.viewmodel.WeatherFragmentViewModel
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class WeatherFragment : Fragment() {
    private lateinit var binding : FragmentWeatherBinding
    private val viewModel : WeatherFragmentViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?, ): View? {
        binding = FragmentWeatherBinding.inflate(layoutInflater)

        viewModel.weatherStatus("2172797")

        binding.apply{
            viewModel.weatherLiveData.observe(viewLifecycleOwner, Observer { weatherData ->
                cityName.text = weatherData.name
                currentDegree.text = "${weatherData.main.temp}°C"
                feelingDegree.text = "${weatherData.main.feels_like}°C"
                maxDegree.text = "${weatherData.main.temp_max}°C"
                minDegree.text = "${weatherData.main.temp_min}°C"
                humadityValue.text = "%${weatherData.main.humidity}"
                speedValue.text = "${weatherData.wind.speed}km/h"
                gustValue.text = "${weatherData.wind.gust}km/h"
                seaLevelValue.text = "${weatherData.main.sea_level}"
                latitudeValue.text = "${weatherData.coord.lat}"
                longtitudeValue.text = "${weatherData.coord.lon}"
                weatherDesc.text = weatherData.weather[0].description
            })
        }




        return binding.root
    }
}