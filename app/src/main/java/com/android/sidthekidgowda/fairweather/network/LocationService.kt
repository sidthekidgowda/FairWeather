package com.android.sidthekidgowda.fairweather.network

import com.google.android.libraries.places.api.model.AutocompletePrediction
import io.reactivex.rxjava3.core.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface LocationService {

    /*
    companion object {
        const val BASE_URL = "https://api.openweathermap.org/data/2.5/"
    }

    @GET("onecall")
    suspend fun getOneCallForecastForLatLong(@Query("lat") latitude: Double,
                                      @Query("lon") longitude: Double,
                                      @Query("appid") apiKey: String): OneCallForecast
                                      https://maps.googleapis.com/maps/api/geocode/json?key=AIzaSyBDcYuscbPQDDbJhajIK8rMLlx25ljiP5M&place_id=ChIJxYAnfM_sOIgRigRCkb7geZI

     */
    @GET("https://maps.googleapis.com/maps/api/geocode/json")
    fun getLatLng(@Query("place_id") placeId: String, @Query("key") apiKey: String): Single<AutocompletePrediction>
}