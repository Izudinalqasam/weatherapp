package com.example.weatheapp.viewmodel

import androidx.lifecycle.ViewModel
import com.example.weatheapp.model.WeatherRespon
import com.example.weatheapp.network.Retrofit
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers


class VMWeatherApp : ViewModel(){

    val retrofit = Retrofit.instance

    fun getJakartaWeather(id: String, appid: String) : Single<WeatherRespon>{
        return retrofit.getWeather(id, appid)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
    }


}