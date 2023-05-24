package com.example.simpleweatherapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.simpleweatherapp.databinding.ActivityMainBinding
import com.example.simpleweatherapp.ui.fragment.SelectionFragment
import com.example.simpleweatherapp.ui.fragment.WeatherFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

         setupBottomMenu()

    }

    private fun setupBottomMenu(){
        binding.bottomBar.onItemSelected = {position ->
            val transaction = supportFragmentManager.beginTransaction()
            when (position){
                0-> transaction.replace(binding.fragmentContainerView.id, WeatherFragment())
                1-> transaction.replace(binding.fragmentContainerView.id, SelectionFragment())
            }

            transaction.commit()
        }
    }
}