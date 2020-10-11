package com.android.sidthekidgowda.fairweather.di.module

import com.android.sidthekidgowda.fairweather.model.Weather
import com.android.sidthekidgowda.fairweather.view.MainActivity
import com.android.sidthekidgowda.fairweather.view.WeatherFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityModule {

//    @ContributesAndroidInjector
//    abstract fun providesMainActivity(): MainActivity

    @ContributesAndroidInjector
    abstract fun providesWeatherFragment(): WeatherFragment
}