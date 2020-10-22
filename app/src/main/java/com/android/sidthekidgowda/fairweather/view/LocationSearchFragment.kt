package com.android.sidthekidgowda.fairweather.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.android.sidthekidgowda.fairweather.BuildConfig
import com.android.sidthekidgowda.fairweather.R
import com.android.sidthekidgowda.fairweather.viewModel.LocationViewModel
import com.google.android.libraries.places.api.Places
import com.jakewharton.rxbinding4.widget.afterTextChangeEvents
import io.reactivex.rxjava3.disposables.CompositeDisposable
import kotlinx.android.synthetic.main.search_fragment.*
import java.util.concurrent.TimeUnit

class LocationSearchFragment : Fragment() {

    private val compositeDisposable = CompositeDisposable()
    val locationViewModel by viewModels<LocationViewModel>()
    private val placesClient by lazy {
        Places.createClient(requireContext())
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        Places.initialize(requireContext(), BuildConfig.PLACES_API)
        return inflater.inflate(R.layout.search_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val adapter = LocationSearchRecyclerAdapter(mutableListOf())
        recycler_view.adapter = adapter

        search_bar.afterTextChangeEvents()
            .skipInitialValue()
            .debounce(300, TimeUnit.MILLISECONDS)
            .subscribe({
                locationViewModel.searchCities(it.editable.toString(), placesClient)
            }, {
            }, {

            })

        locationViewModel.autoCompletedList.observe(viewLifecycleOwner, Observer {
            //set up recycler view
            adapter.setData(it)
        })
    }

    override fun onDestroy() {
        super.onDestroy()
        compositeDisposable.clear()
    }
}