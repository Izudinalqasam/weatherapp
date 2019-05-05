package com.example.weatheapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.weatheapp.Utils.Helper
import com.example.weatheapp.adapter.AdapterForecast5Days
import com.example.weatheapp.databinding.ActivityMainBinding
import com.example.weatheapp.model.dailyforecast.WeatherRespon
import com.example.weatheapp.model.fivedaysforecast.ForecastFiveDays
import com.example.weatheapp.viewmodel.VMWeatherApp
import io.reactivex.disposables.CompositeDisposable
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var viewmodel: VMWeatherApp
    private lateinit var binding: ActivityMainBinding
    private val disposable = CompositeDisposable()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewmodel = ViewModelProviders.of(this).get(VMWeatherApp::class.java)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        getDataDailyForecast()
        getData5DaysForecast()
    }

    private fun getDataDailyForecast(){
        Helper.increment()
        disposable.add(viewmodel.getJakartaWeather(Helper.ID, BuildConfig.APP_ID)
            .subscribe({
                if (it.cod == 200){
                    setDataDailyForecast(it)
                }
            },{
                Helper.decrement()
                Toast.makeText(baseContext, "Something went wrong", Toast.LENGTH_SHORT)
            }))
    }

    private fun getData5DaysForecast(){
        Helper.increment()
        disposable.add(viewmodel.getFiveDaysForecast(Helper.ID, BuildConfig.APP_ID)
            .subscribe({
                if (it.cod == "200"){
                    setAdapterValueList(it.list)
                }
            },{
                Helper.decrement()
                Toast.makeText(baseContext, "Something went wrong", Toast.LENGTH_SHORT)
            }))
    }

    private fun setAdapterValueList(listForecast: List<ForecastFiveDays>){
        val adapter = AdapterForecast5Days(listForecast)

        Toast.makeText(baseContext, "${listForecast[0].weather[0].main}  ${listForecast[0].weather[0].description}", Toast.LENGTH_SHORT).show()

        rv_fivedays_forecast.setHasFixedSize(false)
        rv_fivedays_forecast.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL,false)
        rv_fivedays_forecast.adapter = adapter
        Helper.decrement()
    }

    private fun setDataDailyForecast(weatherRespon: WeatherRespon?){
        binding.weatherDaily = weatherRespon
        Helper.decrement()
    }

    override fun onStop() {
        super.onStop()
        disposable.dispose()
    }
}
