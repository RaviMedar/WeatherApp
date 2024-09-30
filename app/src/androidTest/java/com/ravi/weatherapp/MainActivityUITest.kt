package com.ravi.weatherapp

import android.location.Location
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.RootMatchers
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.rule.GrantPermissionRule
import com.ravi.weatherapp.view.MainActivity
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

// MainActivityTest.kt

@RunWith(AndroidJUnit4::class)
class MainActivityTest {

    @get:Rule
    val activityRule = ActivityScenarioRule(MainActivity::class.java)

    // Test case for adding WeatherFragment on button click
    @Test
    fun testAddWeatherFragment() {
        // Perform a click on the btnAddFragment button
        onView(withId(R.id.btnAddFragment)).perform(click())

        // Check if the WeatherFragment is displayed
        onView(withId(R.id.fragmentContainer)).check(matches(isDisplayed()))
    }

    // Test case for location permission request
    @Test
    fun testRequestLocationPermission() {
        // Use grant/deny permission rules to simulate permission request
        /*val permissionRule: GrantPermissionRule = GrantPermissionRule.grant(
            Manifest.permission.ACCESS_FINE_LOCATION,
            Manifest.permission.ACCESS_COARSE_LOCATION
        )*/

        // Perform click on the getLocation button
        onView(withId(R.id.getLocation)).perform(click())

        // Check if the location permission is requested
        onView(withText("Location permission granted"))
            //.inRoot(RootMatchers.withDecorView(not(activityRule.scenario.result.decorView)))
            .check(matches(isDisplayed()))
    }

    // Test case for denied location permission
    @Test
    fun testLocationPermissionDenied() {
        // Deny permission
        /*val permissionRule: GrantPermissionRule = GrantPermissionRule.deny(
            Manifest.permission.ACCESS_FINE_LOCATION,
            Manifest.permission.ACCESS_COARSE_LOCATION
        )*/

        // Perform click on the getLocation button
        onView(withId(R.id.getLocation)).perform(click())

        // Check if location permission is denied
        onView(withText("Location permission denied"))
            //.inRoot(RootMatchers.withDecorView(not(activityRule.scenario.result.decorView)))
            .check(matches(isDisplayed()))
    }

    // Test case for fetching location
    @Test
    fun testFetchLocation() {
        // Mock location provider (fusedLocationClient) to return a sample location
        val mockLocation = Location("mockProvider")
        mockLocation.latitude = 40.7128
        mockLocation.longitude = -74.0060

        // Simulate button click to fetch location
        onView(withId(R.id.getLocation)).perform(click())

        // Verify that city name is updated correctly
        onView(withText("Location Fetched successfully"))
            //.inRoot(RootMatchers.withDecorView(not(activityRule.scenario.result.decorView)))
            .check(matches(isDisplayed()))
    }
}
