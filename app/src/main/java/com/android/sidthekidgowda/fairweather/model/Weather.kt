package com.android.sidthekidgowda.fairweather.model

import com.squareup.moshi.Json

data class Weather(
    val id: Int,

    @Json(name  = "main")
    val weatherCondition: String,

    val description: String,

    val icon: String
)