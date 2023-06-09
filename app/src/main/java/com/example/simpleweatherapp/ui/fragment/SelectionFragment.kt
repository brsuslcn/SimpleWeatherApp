package com.example.simpleweatherapp.ui.fragment

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.simpleweatherapp.util.CityClickListener
import com.example.simpleweatherapp.databinding.FragmentSelectionBinding
import com.example.simpleweatherapp.ui.adapter.CityAdapter
import com.example.simpleweatherapp.ui.viewmodel.SelectionViewModel
import com.example.simpleweatherapp.util.LocalSharedPref
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

/**
 * This class manages UI of the SelectionFragment
 *
 * @property binding access the views of the FragmentSelection in XML file.
 * @property coroutineScope a CoroutineScope in order to start searchJob
 * @property searchJob manages searching and delaying the search process in order to avoid lags and interrupts while user typing.
 * @property viewModel access SelectionViewModel
 *
 * @see Fragment
 * @see CityClickListener
 * @see AndroidEntryPoint
 */

@AndroidEntryPoint
class SelectionFragment : Fragment(), CityClickListener {
    private lateinit var binding : FragmentSelectionBinding
    private lateinit var coroutineScope: CoroutineScope
    private var searchJob: Job? = null
    private val viewModel : SelectionViewModel by viewModels()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?, ): View? {
        binding = FragmentSelectionBinding.inflate(layoutInflater)
        coroutineScope = CoroutineScope(Dispatchers.Main)


        val cityAdapter = CityAdapter(this, LocalSharedPref(requireContext()))

        viewModel.cityLiveData.observe(viewLifecycleOwner, Observer { cities ->
           cityAdapter.addItems(cities)
        })


        binding.apply {
            recyclerView.layoutManager = LinearLayoutManager(requireContext())
            recyclerView.adapter = cityAdapter

            /**
             * When user search a city, listen to edittext
             *
             * @property TextWatcher
             */
            searchCity.addTextChangedListener(object : TextWatcher{
                override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

                }

                override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                    searchJob?.cancel()
                    searchJob = coroutineScope.launch {
                        delay(400)

                        viewModel.cityLiveData.observe(viewLifecycleOwner, Observer { cities ->
                            if(p0.toString().isNotEmpty())
                            {
                                val searchResults = cities.filter{city ->
                                    city.name.contains(p0.toString(), ignoreCase = true)
                                }
                                cityAdapter.addItems(searchResults)
                            }

                            else{
                                cityAdapter.addItems(cities)
                            }

                        })
                    }
                }

                override fun afterTextChanged(p0: Editable?) {

                }
            })
        }

        return binding.root

    }

    /**
     * In order to access the click event on an item in an adapter, override the onItemClick method and implement it within the adapter as well.
     */
    override fun onItemClick() {
        findNavController().popBackStack()
    }

    /**
     * Cancel searchJob onDestroy not to cause any errors.
     */
    override fun onDestroy() {
        super.onDestroy()
        searchJob?.cancel()
    }
}