package com.android.sidthekidgowda.fairweather.main

import android.app.Application
import com.android.sidthekidgowda.fairweather.BuildConfig
import com.google.android.libraries.places.api.Places
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class FairWeatherApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        Places.initialize(this, BuildConfig.PLACES_API)
    }
}