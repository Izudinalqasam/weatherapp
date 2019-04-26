package com.example.weatheapp

import com.example.weatheapp.Utils.Helper
import com.example.weatheapp.viewmodel.VMWeatherApp
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito.verify
import org.mockito.MockitoAnnotations

class WeatherUnitTest {

    @Mock
    private lateinit var viewModel: VMWeatherApp

    @Before
    fun init(){
        MockitoAnnotations.initMocks(this)
    }

    @Test
    fun testHitAPI(){
        var id = Helper.ID
        var appid = "d449eb5e99d5d229667852f7c5b9553d"

        viewModel.getJakartaWeather(id, appid)
        verify(viewModel).getJakartaWeather(id, appid)
    }
}