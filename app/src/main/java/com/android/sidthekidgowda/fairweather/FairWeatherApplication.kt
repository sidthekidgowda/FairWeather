package com.android.sidthekidgowda.fairweather

import com.android.sidthekidgowda.fairweather.di.DaggerFairWeatherComponent
import dagger.android.AndroidInjector
import dagger.android.support.DaggerApplication

class FairWeatherApplication : DaggerApplication() {
    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        return DaggerFairWeatherComponent.create()
    }
}