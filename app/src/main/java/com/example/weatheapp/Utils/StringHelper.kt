package com.example.weatheapp.Utils

import android.widget.TextView
import androidx.databinding.BindingAdapter
import java.text.DateFormatSymbols
import java.text.SimpleDateFormat
import java.util.*


@BindingAdapter("bind:setClock")
fun setClock(textView: TextView, time: String) {
    val timeSplit = time.split(" ")
    textView.text = "${timeSplit[1].substring(0, 5)} WIB"
}

@BindingAdapter("bind:CustomDate")
fun setCustomDate(textView: TextView, date: String){
    val dateSplit = date.split(" ")
    val dayNames = DateFormatSymbols().weekdays
    val mountNames = DateFormatSymbols().months

    val dateFormat = SimpleDateFormat("yyyy-MM-dd")
    val dateResult = dateFormat.parse(dateSplit[0])

    val calender = Calendar.getInstance()
    calender.time = dateResult

    textView.text = "${dayNames[calender.get(Calendar.DAY_OF_WEEK)]}, ${calender.get(Calendar.DAY_OF_MONTH)}-${mountNames[calender.get(Calendar.MONTH)]}-${calender.get(Calendar.YEAR)}"
}

