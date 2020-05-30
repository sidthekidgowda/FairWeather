package com.android.sidthekidgowda.fairweather.model

import com.squareup.moshi.Json

data class Snow(@Json(name="1h")
                 val hour: Double)