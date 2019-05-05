package com.example.weatheapp.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.weatheapp.databinding.AdvForecast5daysBinding
import com.example.weatheapp.model.fivedaysforecast.ForecastFiveDays


class AdapterForecast5Days(
    private val listWeather: List<ForecastFiveDays>
) : RecyclerView.Adapter<AdapterForecast5Days.Forecast5DaysHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Forecast5DaysHolder {
        val itemView = LayoutInflater.from(parent.context)
        val itemBinding = AdvForecast5daysBinding.inflate(itemView, parent, false)
        return Forecast5DaysHolder(itemBinding)
    }

    override fun getItemCount(): Int = listWeather.size

    override fun onBindViewHolder(holder: Forecast5DaysHolder, position: Int) {
        holder.bindItem(listWeather[position])
    }

    class Forecast5DaysHolder(val itemViewBinding: AdvForecast5daysBinding): RecyclerView.ViewHolder(itemViewBinding.root){

        fun bindItem(forecastFiveDays: ForecastFiveDays){
            itemViewBinding.fiveDaysForecast = forecastFiveDays
            itemViewBinding.executePendingBindings()
        }
    }
}