package com.android.sidthekidgowda.fairweather.di.module

import com.android.sidthekidgowda.fairweather.network.FairWeatherService
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import dagger.Module
import dagger.Provides
import dagger.Reusable
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

@Module
object NetworkModule {

    @JvmStatic
    @Provides
    @Reusable
    fun provideHttpLoggingInterceptor(): HttpLoggingInterceptor {
        return HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)
    }

    @JvmStatic
    @Provides
    @Reusable
    fun providesOKHttpClient(loggingInterceptor: HttpLoggingInterceptor): OkHttpClient {
        return OkHttpClient.Builder().addNetworkInterceptor(loggingInterceptor).build()
    }

    @JvmStatic
    @Provides
    @Reusable
    fun providesMoshi(): Moshi {
        return Moshi.Builder().add(KotlinJsonAdapterFactory()).build()
    }

    @JvmStatic
    @Provides
    @Reusable
    fun providesRetrofitService(okHttpClient: OkHttpClient, moshi: Moshi): Retrofit {
        return Retrofit.Builder()
            .baseUrl(FairWeatherService.BASE_URL)
            .addConverterFactory(MoshiConverterFactory.create(moshi))
            .client(okHttpClient)
            .build()
    }

    @JvmStatic
    @Provides
    @Reusable
    fun providesFairWeatherService(retrofit: Retrofit): FairWeatherService {
        return retrofit.create(FairWeatherService::class.java)
    }

}