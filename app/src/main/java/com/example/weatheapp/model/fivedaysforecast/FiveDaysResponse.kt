package com.example.weatheapp.model.fivedaysforecast

data class FiveDaysResponse(
    val city: City,
    val cnt: Int,
    val cod: String,
    val list: List<ForecastFiveDays>,
    val message: Double
)