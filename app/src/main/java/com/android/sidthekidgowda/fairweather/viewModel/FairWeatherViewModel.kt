package com.android.sidthekidgowda.fairweather.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.android.sidthekidgowda.fairweather.model.OneCallForecast
import com.android.sidthekidgowda.fairweather.network.WeatherService
import kotlinx.coroutines.launch
import javax.inject.Inject

class FairWeatherViewModel @Inject constructor(
    val fairWeatherService: WeatherService
) : ViewModel() {


    private val _oneCallForeCastLiveData = MutableLiveData<OneCallForecast>()
    val oneCallForeCastLiveData: LiveData<OneCallForecast>
        get() = _oneCallForeCastLiveData

    val oneCallForeCastFailure = MutableLiveData<Boolean>()

    fun getOneCallWeather(lat: Double, long: Double, apiKey: String) {
        viewModelScope.launch {
            try {
                val weatherResponse = fairWeatherService.getOneCallForecastForLatLong(lat, long, apiKey)
                _oneCallForeCastLiveData.value = weatherResponse
            } catch (e: Exception) {
                oneCallForeCastFailure.value = true
            }
        }
    }
}