package com.example.eberryassignmentbyparisa.di

import com.example.eberryassignmentbyparisa.data.remote.TvShowsApi
import com.example.eberryassignmentbyparisa.data.repository.RemoteDataSourceImpl
import com.example.eberryassignmentbyparisa.domain.repository.RemoteDataSource
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.create
import javax.inject.Singleton

/**
 * AppModule is a Dagger Hilt module responsible for providing application-wide dependencies.
 * These include the WeatherApi instance for making weather data API requests and
 * the FusedLocationProviderClient for location services.
 */

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideTvShowsApi(): TvShowsApi {
        return Retrofit.Builder()
            .baseUrl("https://api.tvmaze.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create()
    }

    @Provides
    @Singleton
    fun provideMainRepository(api: TvShowsApi): RemoteDataSourceImpl {
        return RemoteDataSourceImpl(api = api )
    }

    @Provides
    @Singleton
    fun providesRemoteDataSource(
        api: TvShowsApi
    ): RemoteDataSource {
        return RemoteDataSourceImpl(
            api = api
        )
    }
}