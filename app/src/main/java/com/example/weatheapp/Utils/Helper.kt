package com.example.weatheapp.Utils

import androidx.test.espresso.idling.CountingIdlingResource

object Helper {
    const val ID = "1642907"

    private val mCustomCounting = CustomIdleResources()

    fun increment() {
        mCustomCounting.increment()
    }

    fun decrement(){
        mCustomCounting.decrement()
    }

    fun getIdlingResources() = mCustomCounting
}