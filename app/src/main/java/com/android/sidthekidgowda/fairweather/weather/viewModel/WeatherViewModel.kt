package com.android.sidthekidgowda.fairweather.weather.viewModel

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.android.sidthekidgowda.fairweather.weather.model.OneCallForecast
import com.android.sidthekidgowda.fairweather.weather.network.WeatherService
import com.google.android.libraries.places.api.net.PlacesClient
import kotlinx.coroutines.launch

class WeatherViewModel @ViewModelInject constructor(
    private val fairWeatherService: WeatherService,
    private val placesClient: PlacesClient
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