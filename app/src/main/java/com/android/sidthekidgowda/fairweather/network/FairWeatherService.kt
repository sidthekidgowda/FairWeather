package com.android.sidthekidgowda.fairweather.network

import com.android.sidthekidgowda.fairweather.model.OneCallForecast
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface FairWeatherService {

    companion object {
        const val BASE_URL = "https://api.openweathermap.org/data/2.5/"
    }

    @GET("onecall")
    suspend fun getOneCallForecastForLatLong(@Query("lat") latitude: Double,
                                      @Query("lon") longitude: Double,
                                      @Query("appid") apiKey: String): OneCallForecast

}