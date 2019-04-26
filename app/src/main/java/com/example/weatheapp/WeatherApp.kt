package com.example.weatheapp

import android.app.Application
import android.content.Context
import androidx.multidex.MultiDex

class WeatherApp : Application(){

    override fun attachBaseContext(base: Context?) {
        super.attachBaseContext(base)
        MultiDex.install(this)
    }
}