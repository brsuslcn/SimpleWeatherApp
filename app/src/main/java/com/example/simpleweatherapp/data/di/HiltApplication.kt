package com.example.simpleweatherapp.data.di

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

/**
 * This class is used for Hilt Entegration
 *
 * This class supplies Hilt Entegration.
 * Hilt which is a library, supplies dependency injection and manages dependencies.
 * We determined this class as "application" in order Hilt to manage and start the application.
 *
 * @See Application
 */
@HiltAndroidApp
class HiltApplication : Application() {
}