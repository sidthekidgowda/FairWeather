package com.android.sidthekidgowda.fairweather.di

import com.android.sidthekidgowda.fairweather.FairWeatherApplication
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule

@Component(modules = [AndroidSupportInjectionModule::class])
interface FairWeatherComponent : AndroidInjector<FairWeatherApplication>