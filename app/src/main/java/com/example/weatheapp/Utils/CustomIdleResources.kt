package com.example.weatheapp.Utils

import androidx.test.espresso.IdlingResource
import java.util.concurrent.atomic.AtomicInteger

class CustomIdleResources : IdlingResource {

    private val counter = AtomicInteger(0)

    private var resourceCallback: IdlingResource.ResourceCallback? = null

    override fun getName(): String {
        return "weatherapp"
    }

    override fun isIdleNow(): Boolean {
        return counter.get() == 0
    }

    override fun registerIdleTransitionCallback(callback: IdlingResource.ResourceCallback?) {
        this.resourceCallback = callback
    }

    fun increment(){
        counter.getAndIncrement()
    }

    fun decrement(){
        var initCounterVal = counter.decrementAndGet()
        if (initCounterVal == 0){

            if (null != resourceCallback){
                resourceCallback!!.onTransitionToIdle()
            }
        }
    }
}