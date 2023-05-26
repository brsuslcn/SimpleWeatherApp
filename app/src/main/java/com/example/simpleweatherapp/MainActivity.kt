package com.example.simpleweatherapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
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
        val navHostFragment = supportFragmentManager.findFragmentById(R.id.fragmentContainerView) as NavHostFragment
        NavigationUI.setupWithNavController(binding.bottomBar, navHostFragment.navController)
    }
}