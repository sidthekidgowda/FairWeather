package com.android.sidthekidgowda.fairweather.di.module

import com.android.sidthekidgowda.fairweather.weather.view.WeatherFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityModule {

    @ContributesAndroidInjector
    abstract fun providesWeatherFragment(): WeatherFragment
}