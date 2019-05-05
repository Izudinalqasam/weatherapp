package com.example.weatheapp.viewmodel

import androidx.lifecycle.ViewModel
import com.example.weatheapp.model.dailyforecast.WeatherRespon
import com.example.weatheapp.model.fivedaysforecast.FiveDaysResponse
import com.example.weatheapp.repository.Repository
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers


class VMWeatherApp : ViewModel(){

    private val repository = Repository.getInstance()

    fun getJakartaWeather(id: String, appid: String) : Single<WeatherRespon>{
        return repository.getDataSource().getWeather(id, appid)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
    }

    fun getFiveDaysForecast(id: String, appid: String): Single<FiveDaysResponse> {
        return repository.getDataSource().getFiveDaysForecast(id, appid)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
    }
}