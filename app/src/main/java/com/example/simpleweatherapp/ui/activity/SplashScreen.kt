package com.example.simpleweatherapp.ui.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.activity.viewModels
import com.example.simpleweatherapp.MainActivity
import com.example.simpleweatherapp.databinding.ActivitySplashScreenBinding
import com.example.simpleweatherapp.ui.viewmodel.SelectionViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SplashScreen : AppCompatActivity() {
    private lateinit var binding : ActivitySplashScreenBinding
    private val viewModel : SelectionViewModel by viewModels()
    private val SPLASH_TIME = 3000L
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySplashScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)

       Handler(Looper.getMainLooper()).postDelayed({
          viewModel.getCities("city_list.json")
           startActivity(Intent(this, MainActivity::class.java))
       }, SPLASH_TIME)
    }
}