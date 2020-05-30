package com.android.sidthekidgowda.fairweather

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.android.sidthekidgowda.fairweather.viewModel.FairWeatherViewModel
import dagger.android.support.DaggerAppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

class MainActivity : DaggerAppCompatActivity() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val weatherViewModel = ViewModelProvider(this, viewModelFactory).get(FairWeatherViewModel::class.java)

        start_service_call.setOnClickListener {
            start_service_call.isEnabled = false
            progress.visibility = View.VISIBLE

            //39.961178 - lat
            //-82.998795 - long

            weatherViewModel.getOneCallWeather(39.961178, -82.998795, BuildConfig.WEATHER_API)
        }

        weatherViewModel.oneCallForeCastLiveData.observe(this, Observer {
            Log.d("MAIN ACTIVITY CALL","SUCCESS CALL")
            progress.visibility = View.GONE
        })

        weatherViewModel.oneCallForeCastFailure.observe(this, Observer {
            Log.d("MAIN ACTIVITY CALL","FAILURE CALL")
            progress.visibility = View.GONE
        })

    }
}
