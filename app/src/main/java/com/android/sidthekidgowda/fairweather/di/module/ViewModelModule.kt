package com.android.sidthekidgowda.fairweather.di.module

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.android.rxviewmodelutility.ViewModelFactory
import com.android.rxviewmodelutility.ViewModelKey
import com.android.sidthekidgowda.fairweather.weather.viewModel.FairWeatherViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class ViewModelModule {

    @Binds
    abstract fun bindsViewModelFactory(viewModelFactory: ViewModelFactory): ViewModelProvider.Factory

    @Binds
    @IntoMap
    @ViewModelKey(FairWeatherViewModel::class)
    abstract fun bindsFairWeatherViewModel(fairWeatherViewModel: FairWeatherViewModel): ViewModel
}