package com.android.sidthekidgowda.fairweather.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.android.sidthekidgowda.fairweather.model.OneCallForecast
import com.android.sidthekidgowda.fairweather.network.FairWeatherService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.lang.Exception
import javax.inject.Inject

class FairWeatherViewModel @Inject constructor(
    val fairWeatherService: FairWeatherService
) : ViewModel() {


    private val _oneCallForeCastLiveData = MutableLiveData<OneCallForecast>()
    val oneCallForeCastLiveData: LiveData<OneCallForecast>
        get() = _oneCallForeCastLiveData

    val oneCallForeCastFailure = MutableLiveData<Boolean>()

    fun getOneCallWeather(lat: Double, long: Double, apiKey: String) {
        viewModelScope.launch {
            try {
                val weatherResponse = makeWeatherCall(lat, long, apiKey)
                if (weatherResponse.isSuccessful) {
                    //handle success
                    _oneCallForeCastLiveData.value = weatherResponse.body()!!
                } else {
                    //handle failure
                    oneCallForeCastFailure.value = true
                }
            } catch (e: Exception) {
                oneCallForeCastFailure.value = true
            }
        }
    }

    suspend fun makeWeatherCall(lat: Double, long: Double, apiKey: String) = withContext(Dispatchers.IO) {
        fairWeatherService.getOneCallForecastForLatLong(lat, long, apiKey)
    }
}