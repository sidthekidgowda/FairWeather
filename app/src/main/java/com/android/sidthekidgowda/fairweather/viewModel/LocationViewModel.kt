package com.android.sidthekidgowda.fairweather.viewModel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.google.android.libraries.places.api.model.AutocompletePrediction
import com.google.android.libraries.places.api.model.AutocompleteSessionToken
import com.google.android.libraries.places.api.model.TypeFilter
import com.google.android.libraries.places.api.net.PlacesClient
import com.google.android.libraries.places.ktx.api.net.awaitFindAutocompletePredictions
import com.google.android.libraries.places.ktx.api.net.findAutocompletePredictionsRequest
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.schedulers.Schedulers
import kotlinx.coroutines.rx3.rxSingle

class LocationViewModel : ViewModel() {

    private var _autoCompleteList = MutableLiveData<List<AutocompletePrediction>>()
    val autoCompletedList: LiveData<List<AutocompletePrediction>> = _autoCompleteList

    private val compositeDispoable = CompositeDisposable()

    fun searchCities(query: String, placesClient: PlacesClient) {
        Log.d("ViewModel", query)

        val token = AutocompleteSessionToken.newInstance()
        val request = findAutocompletePredictionsRequest {
            this.query = query
            typeFilter = TypeFilter.REGIONS
            countries = listOf("US")
        }

        compositeDispoable.add(
            rxSingle { placesClient.awaitFindAutocompletePredictions(request) }
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                _autoCompleteList.value = it.autocompletePredictions
            },{
                _autoCompleteList.value = listOf()
            }))
    }


    override fun onCleared() {
        super.onCleared()
        compositeDispoable.dispose()
    }

}