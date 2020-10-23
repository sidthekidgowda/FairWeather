package com.android.sidthekidgowda.fairweather.weather.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.navArgs
import com.android.sidthekidgowda.fairweather.R
import com.android.sidthekidgowda.fairweather.weather.viewModel.FairWeatherViewModel
import dagger.android.support.DaggerFragment
import javax.inject.Inject

class WeatherFragment : DaggerFragment() {
    @Inject lateinit var viewModelFactory: ViewModelProvider.Factory

    val args: WeatherFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.weather_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val weatherViewModel = ViewModelProvider(this, viewModelFactory).get(FairWeatherViewModel::class.java)

        val placeId = args.placeId
        val place = args.place
//
//        start_service_call.setOnClickListener {
//            start_service_call.isEnabled = false
//            service_call_done.visibility = View.GONE
//            progress.visibility = View.VISIBLE
//
//            //39.961178 - lat
//            //-82.998795 - long
//
//            weatherViewModel.getOneCallWeather(39.961178, -82.998795, BuildConfig.WEATHER_API)
//        }
//
//        weatherViewModel.oneCallForeCastLiveData.observe(viewLifecycleOwner, Observer {
//            Log.d("MAIN ACTIVITY CALL","SUCCESS CALL")
//            progress.visibility = View.GONE
//            service_call_done.visibility = View.VISIBLE
//            service_call_done.text = "SUCCESS WEATHER CALL"
//            start_service_call.isEnabled = true
//        })
//
//        weatherViewModel.oneCallForeCastFailure.observe(viewLifecycleOwner, Observer {
//            Log.d("MAIN ACTIVITY CALL","FAILURE CALL")
//            progress.visibility = View.GONE
//            service_call_done.visibility = View.VISIBLE
//            service_call_done.text = "FAILURE WEATHER CALL"
//            start_service_call.isEnabled = true
//        })

    }
}