package com.example.simpleweatherapp.ui.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.lifecycleScope
import com.example.simpleweatherapp.R
import com.example.simpleweatherapp.data.model.cities_model.CityModel
import com.example.simpleweatherapp.databinding.FragmentSelectionBinding
import com.example.simpleweatherapp.ui.viewmodel.SelectionViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch


@AndroidEntryPoint
class SelectionFragment : Fragment() {
    private lateinit var binding : FragmentSelectionBinding
    private val viewModel : SelectionViewModel by viewModels()
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?, ): View? {
        binding = FragmentSelectionBinding.inflate(layoutInflater)


        viewModel.cityLiveData.observe(viewLifecycleOwner, Observer { cities ->
            binding.textView.text = cities[0].name
        })


        return binding.root

    }
}