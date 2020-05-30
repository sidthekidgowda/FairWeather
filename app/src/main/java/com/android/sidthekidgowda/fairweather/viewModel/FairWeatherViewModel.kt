package com.android.sidthekidgowda.fairweather.viewModel

import androidx.lifecycle.ViewModel
import com.android.sidthekidgowda.fairweather.network.FairWeatherService
import javax.inject.Inject

class FairWeatherViewModel @Inject constructor(
    fairWeatherService: FairWeatherService
) : ViewModel() {


}