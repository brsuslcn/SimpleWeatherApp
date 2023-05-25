package com.example.simpleweatherapp.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.simpleweatherapp.databinding.FragmentSelectionBinding
import com.example.simpleweatherapp.ui.adapter.CityAdapter
import com.example.simpleweatherapp.ui.viewmodel.SelectionViewModel
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class SelectionFragment : Fragment() {
    private lateinit var binding : FragmentSelectionBinding
    private val viewModel : SelectionViewModel by viewModels()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?, ): View? {
        binding = FragmentSelectionBinding.inflate(layoutInflater)


        val cityAdapter = CityAdapter()

        viewModel.cityLiveData.observe(viewLifecycleOwner, Observer { cities ->
           cityAdapter.addItems(cities)
        })

        binding.apply {
            recyclerView.layoutManager = LinearLayoutManager(requireContext())
            recyclerView.adapter = cityAdapter
        }


        return binding.root

    }
}