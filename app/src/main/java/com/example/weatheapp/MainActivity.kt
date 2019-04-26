package com.example.weatheapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import androidx.databinding.BindingAdapter
import androidx.databinding.BindingConversion
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import androidx.test.espresso.idling.CountingIdlingResource
import com.example.weatheapp.Utils.Helper
import com.example.weatheapp.databinding.ActivityMainBinding
import com.example.weatheapp.model.WeatherRespon
import com.example.weatheapp.viewmodel.VMWeatherApp
import io.reactivex.disposables.Disposable
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var viewmodel: VMWeatherApp
    private lateinit var disposable: Disposable
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewmodel = ViewModelProviders.of(this).get(VMWeatherApp::class.java)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        getData()
    }

    private fun getData(){
        Helper.increment()
        disposable = viewmodel.getJakartaWeather(Helper.ID, BuildConfig.APP_ID)
            .subscribe({
                if (it.cod == 200){
                    setData(it)
                }
            },{
                Helper.decrement()
                Toast.makeText(baseContext, "Something went wrong", Toast.LENGTH_SHORT)
            })
    }

    private fun setData(weatherRespon: WeatherRespon){
        binding.weather = weatherRespon
        Helper.decrement()
    }

    override fun onStop() {
        super.onStop()
        disposable.dispose()
    }
}
