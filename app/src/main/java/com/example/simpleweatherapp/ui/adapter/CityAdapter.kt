package com.example.simpleweatherapp.ui.adapter


import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.simpleweatherapp.util.CityClickListener
import com.example.simpleweatherapp.data.model.cities_model.CityModelItem
import com.example.simpleweatherapp.databinding.CityLayoutBinding
import com.example.simpleweatherapp.util.LocalSharedPref

/**
 * For the recyclerview, this is a special class. In order to show city lists, this class is being used.
 *
 * @property CityClickListener when the city clicked, it supplies to navigate to WeatherFragment. This listens the click of the city items.
 * @property LocalSharedPref is used to manage the sharedPreferences file. The selected city is stored in sharedPreferences, so when the application is restarted, it starts with the same selected city.
 * @property cityList A temporary empty list that holds city data
 */
class CityAdapter(private val cityClickListener: CityClickListener, private val localSharedPref: LocalSharedPref) : RecyclerView.Adapter<CityAdapter.ItemViewHolder>() {
    private var cityList = emptyList<CityModelItem>()

    /**
     * A nested class that holds the content of the RecyclerView.
     *
     * @property binding access views in CityLayout XML file.
     */
    inner class ItemViewHolder(private val binding : CityLayoutBinding) : RecyclerView.ViewHolder(binding.root){
        /**
         * It binds the item data at a specific position.
         *
         * @param item a CityModelItem
         */
        fun bind(item : CityModelItem)
        {
            binding.cityName.text = item.name
            binding.root.setOnClickListener()
            {
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

    /**
     * This function adds items to recyclerview
     *
     * @param newItem a list of CityModelItem
     */
    fun addItems(newItem : List<CityModelItem>)
    {
        cityList = newItem
        notifyDataSetChanged()
    }
}