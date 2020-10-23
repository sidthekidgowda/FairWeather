package com.android.sidthekidgowda.fairweather.location.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.android.sidthekidgowda.fairweather.R
import com.android.sidthekidgowda.fairweather.location.viewModel.LocationViewModel
import com.jakewharton.rxbinding4.widget.afterTextChangeEvents
import dagger.hilt.android.AndroidEntryPoint
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.disposables.CompositeDisposable
import kotlinx.android.synthetic.main.search_fragment.*
import java.util.concurrent.TimeUnit

@AndroidEntryPoint
class LocationSearchFragment : Fragment() {

    private val compositeDisposable = CompositeDisposable()
    private val locationViewModel by viewModels<LocationViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.search_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val adapter = LocationSearchRecyclerAdapter(mutableListOf())
        recycler_view.adapter = adapter

        compositeDisposable.add(search_bar.afterTextChangeEvents()
            .skipInitialValue()
            .debounce(300, TimeUnit.MILLISECONDS)
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                locationViewModel.searchCities(it.editable.toString())
            }, {
            }, {

            }))

        locationViewModel.autoCompletedList.observe(viewLifecycleOwner, Observer {
            //set up recycler view
            adapter.setData(it)
        })
    }

    override fun onDestroy() {
        super.onDestroy()
        compositeDisposable.dispose()
    }
}