package com.android.sidthekidgowda.fairweather.weather.di

import com.android.sidthekidgowda.fairweather.weather.network.WeatherService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityRetainedComponent
import dagger.hilt.android.scopes.ActivityRetainedScoped
import retrofit2.Retrofit

@Module
@InstallIn(ActivityRetainedComponent::class)
object WeatherModule {

    @Provides
    @ActivityRetainedScoped
    fun providesFairWeatherService(retrofit: Retrofit): WeatherService {
        return retrofit.create(WeatherService::class.java)
    }
}