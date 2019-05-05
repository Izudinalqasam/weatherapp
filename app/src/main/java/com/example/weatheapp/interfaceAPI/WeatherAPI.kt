package com.example.weatheapp.interfaceAPI

import com.example.weatheapp.model.dailyforecast.WeatherRespon
import com.example.weatheapp.model.fivedaysforecast.FiveDaysResponse
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherAPI {

    @GET("data/2.5/weather")
    fun getWeather(@Query("id") id: String,
                   @Query("appid") appid: String) : Single<WeatherRespon>

    @GET("data/2.5/forecast")
    fun getFiveDaysForecast(@Query("id") id: String,
                            @Query("appid") appid: String) : Single<FiveDaysResponse>
}