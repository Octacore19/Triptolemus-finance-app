package com.chegsmania.triptotracker.remote

import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object TrackerApiService {

    fun createService(): TrackerApiInterface{
        val retrofit = Retrofit.Builder()
            .baseUrl("https://finance-tracker-server.herokuapp.com/api/")
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(CoroutineCallAdapterFactory())
            .build()
        return retrofit.create(TrackerApiInterface::class.java)
    }
}