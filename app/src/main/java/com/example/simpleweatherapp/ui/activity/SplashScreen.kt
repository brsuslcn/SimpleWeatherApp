package com.example.simpleweatherapp.ui.activity

import android.content.Context
import android.content.Intent
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.activity.viewModels
import androidx.appcompat.app.AlertDialog
import androidx.lifecycle.lifecycleScope
import com.example.simpleweatherapp.MainActivity
import com.example.simpleweatherapp.databinding.ActivitySplashScreenBinding
import com.example.simpleweatherapp.ui.viewmodel.SelectionViewModel
import com.example.simpleweatherapp.util.LocalSharedPref
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.async
import kotlinx.coroutines.cancel
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

/**
 * When the application runs, this class starts directly.
 *
 * This class managed the first screen of the application.
 * Cheecks the internet connection.
 * Manages sharedPreferences file. If the file is not exist, it creates the file and select the initial city.
 * From the json file, all data is being fetched, while fetching splash animation is showed to user.
 * After the fetching all data successfully, the splash screen ends.
 *
 * @property binding supplies to access layout file safety.
 * @property viewModel supplies to access SelectionViewModel and fetching cities data from the json file.
 * @property DEFAULT_CITY default cityId is determined here in order to write sharedPreferences file.
 * @property job a coroutineScope supplies to fetching data and managing the SplashScreen.
 *
 *
 */
@AndroidEntryPoint
class SplashScreen : AppCompatActivity() {
    private lateinit var binding : ActivitySplashScreenBinding
    private val viewModel : SelectionViewModel by viewModels()
    private val DEFAULT_CITY = "745042"
    private val  job = CoroutineScope(Dispatchers.Main)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySplashScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val localSharedPref = LocalSharedPref(applicationContext)

        if(!localSharedPref.isSharedPreferencesExists())
        {
            localSharedPref.writeSelectedCity(DEFAULT_CITY)
        }

        if(!isNetworkAvailable(this))
        {
            val builder = AlertDialog.Builder(this)
            builder.setTitle("Internet Connection")
            builder.setMessage("Please check your internet connection.")
            builder.setPositiveButton("Exit"){dialog, which->
                finish()
            }
            builder.setCancelable(false)
            builder.show()
            return
        }

            job.launch {
                withContext(Dispatchers.IO)
                {
                    viewModel.getCities("city_list.json")
                }
                startActivity(Intent(applicationContext, MainActivity::class.java))
                finish()
        }

    }

    /**
     * The function checks if the internet connection is available.
     *
     * @param context a Context
     * @return shows if the internet connection is exist and return it as a Boolean
     */
    fun isNetworkAvailable(context: Context): Boolean {
        val connectivityManager = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val networkCapabilities = connectivityManager.getNetworkCapabilities(connectivityManager.activeNetwork)
        return networkCapabilities?.hasCapability(NetworkCapabilities.NET_CAPABILITY_INTERNET) ?: false
    }

    /**
     * When the activity destroyed, cancel the joined job.
     */
    override fun onDestroy() {
        super.onDestroy()
        job.cancel()
    }
}