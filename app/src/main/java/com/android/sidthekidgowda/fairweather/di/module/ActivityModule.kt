package com.android.sidthekidgowda.fairweather.di.module

import com.android.sidthekidgowda.fairweather.view.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityModule {

    @ContributesAndroidInjector
    abstract fun providesMainActivity(): MainActivity
}