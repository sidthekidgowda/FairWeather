package com.android.sidthekidgowda.fairweather.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.android.sidthekidgowda.fairweather.R
import com.android.sidthekidgowda.fairweather.viewModel.LocationViewModel
import com.jakewharton.rxbinding4.widget.afterTextChangeEvents
import io.reactivex.rxjava3.disposables.CompositeDisposable
import kotlinx.android.synthetic.main.search_fragment.*
import java.util.concurrent.TimeUnit

class LocationSearchFragment : Fragment() {

    private val compositeDisposable = CompositeDisposable()
    val locationViewModel by viewModels<LocationViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.search_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        search_bar.afterTextChangeEvents()
            .skipInitialValue()
            .debounce(300, TimeUnit.MILLISECONDS)
            .subscribe({
                locationViewModel.searchCities(it.toString())
            }, {
            }, {

            })



        locationViewModel.autoCompletedList.observe(viewLifecycleOwner, Observer {
            //set up recycler view
        })
    }

    override fun onDestroy() {
        super.onDestroy()
        compositeDisposable.clear()
    }
}