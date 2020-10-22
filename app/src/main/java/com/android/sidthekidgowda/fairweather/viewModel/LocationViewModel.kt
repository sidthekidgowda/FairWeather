package com.android.sidthekidgowda.fairweather.viewModel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.google.android.libraries.places.api.model.AutocompletePrediction

class LocationViewModel : ViewModel() {

    private var _autoCompleteList = MutableLiveData<List<AutocompletePrediction>>()
    val autoCompletedList: LiveData<List<AutocompletePrediction>> = _autoCompleteList

    fun searchCities(query: String) {
        Log.d("ViewModel", query)
    }


}