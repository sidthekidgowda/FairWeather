package com.android.sidthekidgowda.fairweather.weather.network

import com.android.sidthekidgowda.fairweather.weather.model.OneCallForecast
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherService {

    companion object {
        const val BASE_URL = "https://api.openweathermap.org/data/2.5/"
    }

    @GET("onecall")
    suspend fun getOneCallForecastForLatLong(@Query("lat") latitude: Double,
                                      @Query("lon") longitude: Double,
                                      @Query("appid") apiKey: String): OneCallForecast

}