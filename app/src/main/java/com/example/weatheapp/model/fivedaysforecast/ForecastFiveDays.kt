package com.example.weatheapp.model.fivedaysforecast

data class ForecastFiveDays(
    val clouds: CloudsFiveDays,
    val dt: Int,
    val dt_txt: String,
    val main: MainFiveDays,
    val rain: RainFiveDays,
    val sys: SysFiveDays,
    val weather: List<WeatherFiveDays>,
    val wind: WindFiveDays
)