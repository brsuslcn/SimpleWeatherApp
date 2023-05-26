package com.example.simpleweatherapp.ui.adapter

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.simpleweatherapp.util.CityClickListener
import com.example.simpleweatherapp.data.model.cities_model.CityModelItem
import com.example.simpleweatherapp.databinding.CityLayoutBinding
import com.example.simpleweatherapp.util.LocalSharedPref
import java.util.Locale

class CityAdapter(private val cityClickListener: CityClickListener, private val localSharedPref: LocalSharedPref) : RecyclerView.Adapter<CityAdapter.ItemViewHolder>() {

    private var cityList = emptyList<CityModelItem>()
    private var searchedList : List<CityModelItem> = cityList

    inner class ItemViewHolder(private val binding : CityLayoutBinding) : RecyclerView.ViewHolder(binding.root){
        fun bind(item : CityModelItem)
        {

            binding.cityName.text = item.name

            binding.root.setOnClickListener()
            {
                Log.e("info", "city name: ${item.name}, cityid: ${item.id}")
                cityClickListener.onItemClick()

                localSharedPref.writeSelectedCity(item.id.toString())
            }

        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CityAdapter.ItemViewHolder {
       val binding = CityLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ItemViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CityAdapter.ItemViewHolder, position: Int) {
         val item = cityList[position]
        holder.bind(item)
    }

    override fun getItemCount(): Int {
        return cityList.size
    }

    fun addItems(newItem : List<CityModelItem>)
    {
        cityList = newItem
        notifyDataSetChanged()
    }
}