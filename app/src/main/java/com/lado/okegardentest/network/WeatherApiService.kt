package com.lado.okegardentest.network

import com.lado.okegardentest.model.WeatherResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherApiService {

    // Get current weather data
    @GET("current.json")
    fun getCurrentWeather(
        @Query("key") key: String,
        @Query("q") city: String
    ): Call<WeatherResponse>
}