package com.android.sidthekidgowda.fairweather.di

import com.android.sidthekidgowda.fairweather.FairWeatherApplication
import com.android.sidthekidgowda.fairweather.di.module.ActivityModule
import com.android.sidthekidgowda.fairweather.di.module.NetworkModule
import com.android.sidthekidgowda.fairweather.di.module.ViewModelModule
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule

@Component(
    modules = [
        AndroidSupportInjectionModule::class,
        NetworkModule::class,
        ViewModelModule::class,
        ActivityModule::class
    ]
)
interface FairWeatherComponent : AndroidInjector<FairWeatherApplication>