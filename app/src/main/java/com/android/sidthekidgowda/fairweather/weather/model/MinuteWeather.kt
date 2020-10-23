package com.android.sidthekidgowda.fairweather.weather.model

import com.squareup.moshi.Json

data class MinuteWeather(@Json(name = "dt") val time: Int,
                         val precipitation: Double)