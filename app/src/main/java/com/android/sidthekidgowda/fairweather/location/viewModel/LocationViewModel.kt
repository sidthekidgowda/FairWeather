package com.android.sidthekidgowda.fairweather.location.viewModel

import android.util.Log
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.android.sidthekidgowda.fairweather.location.model.SessionToken
import com.google.android.libraries.places.api.model.AutocompletePrediction
import com.google.android.libraries.places.api.model.TypeFilter
import com.google.android.libraries.places.api.net.PlacesClient
import com.google.android.libraries.places.ktx.api.net.awaitFindAutocompletePredictions
import com.google.android.libraries.places.ktx.api.net.findAutocompletePredictionsRequest
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.schedulers.Schedulers
import kotlinx.coroutines.rx3.rxSingle

class LocationViewModel @ViewModelInject constructor(
    private val placesClient: PlacesClient
) : ViewModel() {

    private var _autoCompleteList = MutableLiveData<List<AutocompletePrediction>>()
    val autoCompletedList: LiveData<List<AutocompletePrediction>> = _autoCompleteList

    private val compositeDispoable = CompositeDisposable()

    fun searchCities(query: String) {
        Log.d("ViewModel", query)

        val request = findAutocompletePredictionsRequest {
            this.query = query
            this.sessionToken = SessionToken.getToken()
            typeFilter = TypeFilter.CITIES
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