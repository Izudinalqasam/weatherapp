package com.example.weatheapp.model.dailyforecast

import com.example.weatheapp.model.fivedaysforecast.WeatherFiveDays

data class WeatherRespon(
    val base: String,
    val clouds: Clouds,
    val cod: Int,
    val coord: Coord,
    val dt: Int,
    val id: Int,
    val main: Main,
    val name: String,
    val sys: Sys,
    val visibility: Int,
    val weather: List<WeatherFiveDays>,
    val wind: Wind
)