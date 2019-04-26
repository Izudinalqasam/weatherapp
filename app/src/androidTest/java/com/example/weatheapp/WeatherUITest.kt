package com.example.weatheapp

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.IdlingRegistry
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.rule.ActivityTestRule
import androidx.test.runner.AndroidJUnit4
import androidx.test.runner.AndroidJUnitRunner
import com.example.weatheapp.Utils.Helper
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class WeatherUITest{

    @get:Rule
    var mainActivity = ActivityTestRule(MainActivity::class.java)


    @Before
    fun registeredIdleResources(){
        IdlingRegistry.getInstance().register(Helper.getIdlingResources())
    }

    @Test
    fun testUI(){
        onView(withId(R.id.tv_daerah_name)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_daerah_name)).check(matches(withText("Daerah Khusus Ibukota Jakarta")))
    }

    @After
    fun unRegisterIdlingResources(){
        IdlingRegistry.getInstance().unregister(Helper.getIdlingResources())
    }
}