package com.android.sidthekidgowda.fairweather.network

import com.android.sidthekidgowda.fairweather.model.OneCallForecast
import retrofit2.http.GET
import retrofit2.http.Query

interface FairWeatherService {

    companion object {
        const val BASE_URL = "http://api.openweathermap.org/data/2.5/"
    }

    @GET("onecall?lat={lat}&lon={lon}&appid={api_key}")
    suspend fun getOneCallForecastForLatLong(@Query("lat") latitude: Double,
                                      @Query("lon") longitude: Double,
                                      @Query("api_key") apiKey: String): OneCallForecast

}