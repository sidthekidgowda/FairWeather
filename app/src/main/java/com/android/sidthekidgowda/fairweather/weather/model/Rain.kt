package com.android.sidthekidgowda.fairweather.weather.model

import com.squareup.moshi.Json

data class Rain(
    @Json(name="1h")
    val hour: Double)