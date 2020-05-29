package com.android.sidthekidgowda.fairweather.model

import com.squareup.moshi.Json

data class OneCallForecast(
    val lat: Double,

    val lon: Double,

    val timezone: String,

    @Json(name = "current")
    val currentWeather: CurrentWeather,

    @Json(name = "minutely")
    val minuteWeather: List<MinuteWeather>,

    @Json(name = "daily")

    val dailyWeather: List<DailyWeather>
)