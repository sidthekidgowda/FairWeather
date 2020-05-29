package com.android.sidthekidgowda.fairweather.model

import com.squareup.moshi.Json

data class CurrentWeather(
    @Json(name = "dt")
    val time: Int,

    val sunrise: Int,

    val sunset: Int,

    val temp: Temperature,

    @Json(name = "feels_like")
    val feelsLike: Temperature,

    val pressure: Int,

    val humidity: Int,

    @Json(name = "uvi")
    val uvIndex: Double,

    @Json(name = "clouds")
    val cloudiness: Int,

    val visibility: Int,

    @Json(name = "wind_speed")
    val windSpeed: Double,

    @Json(name = "wind_deg")
    val windDegree: Int,

    val weather: List<Weather>,

    val rain: Double,

    val snow: Double
)