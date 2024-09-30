package com.ravi.weatherapp.view

import android.Manifest
import android.content.pm.PackageManager
import android.location.Address
import android.location.Geocoder
import android.location.Location
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationServices
import com.ravi.weatherapp.R
import java.io.IOException
import java.util.Locale


class MainActivity : AppCompatActivity() {


    private lateinit var fusedLocationClient: FusedLocationProviderClient
    private val LOCATION_PERMISSION_REQUEST_CODE = 1
    private  var city: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val btnAddFragment: Button = findViewById(R.id.btnAddFragment)
        val btnFetch: Button = findViewById(R.id.getLocation)

        btnAddFragment.setOnClickListener {
            addFirstFragment()
        }
        btnFetch.setOnClickListener {
            getLocation()
        }
    }

    private fun addFirstFragment() {
        // Create an instance of the fragment
        val weatherFragment = WeatherFragment()

        // Get the FragmentManager and start a transaction
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()

        // Replace the contents of the container with the new fragment
        fragmentTransaction.replace(R.id.fragmentContainer, weatherFragment)

        // Optionally add the transaction to the back stack
        fragmentTransaction.addToBackStack(null)

        // Commit the transaction
        fragmentTransaction.commit()

    }

     fun getLocation() {

        // Initialize FusedLocationProviderClient
        fusedLocationClient = LocationServices.getFusedLocationProviderClient(this)

        // Check for location permissions
        if (ActivityCompat.checkSelfPermission(
                this,
                Manifest.permission.ACCESS_FINE_LOCATION
            ) != PackageManager.PERMISSION_GRANTED &&
            ActivityCompat.checkSelfPermission(
                this,
                Manifest.permission.ACCESS_COARSE_LOCATION
            ) != PackageManager.PERMISSION_GRANTED
        ) {
            // Request location permissions
            ActivityCompat.requestPermissions(
                this,
                arrayOf(
                    Manifest.permission.ACCESS_FINE_LOCATION,
                    Manifest.permission.ACCESS_COARSE_LOCATION
                ),
                LOCATION_PERMISSION_REQUEST_CODE
            )
        } else {
            // If permissions are already granted, get location
            getCurrentLocation()
        }
    }

    private fun getCurrentLocation() {
        fusedLocationClient.lastLocation
            .addOnSuccessListener { location: Location? ->
                if (location != null) {
                    val latitude = location.latitude
                    val longitude = location.longitude
                    // Perform reverse geocoding to get city name
                    getCityName(latitude, longitude)
                } else {
                   // tvCityName.text = "Unable to retrieve location"
                    Toast.makeText(this, "Location is null", Toast.LENGTH_SHORT).show()
                }
            }
            .addOnFailureListener { e ->
              //  tvCityName.text = "Failed to get location"
                Toast.makeText(this, "Error: ${e.message}", Toast.LENGTH_SHORT).show()
            }
    }

    // Reverse Geocoding to get City Name
    private fun getCityName(latitude: Double, longitude: Double) {
        val geocoder = Geocoder(this, Locale.getDefault())
        try {
            val addresses: List<Address>? = geocoder.getFromLocation(latitude, longitude, 1)
            if (!addresses.isNullOrEmpty()) {
                val address: Address = addresses[0]
                var cityName: String? = address.locality

                if (cityName.isNullOrEmpty()) {
                    // Fallback if locality is not available
                    cityName = address.subAdminArea
                }

                if (cityName.isNullOrEmpty()) {
                    // Further fallback if sub-admin area is not available
                    cityName = address.adminArea
                }

                if (!cityName.isNullOrEmpty()) {
                    // Display the city name
                   //   tvCityName.text = "City: $cityName"
                    city = cityName
                    Toast.makeText(this, "Location Fetched successfully", Toast.LENGTH_SHORT).show()
                } else {
                 //   tvCityName.text = "Unable to determine city name"
                }
            } else {
               // tvCityName.text = "No address found for the location"
            }
        } catch (e: IOException) {
            e.printStackTrace()
          //  tvCityName.text = "Geocoder service not available"
            Toast.makeText(this, "Geocoder service not available", Toast.LENGTH_SHORT).show()
        }
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if (requestCode == LOCATION_PERMISSION_REQUEST_CODE) {
            if ((grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED)) {
                // Permission granted, get the location
                getCurrentLocation()
            } else {
              //  tvCityName.text = "Location permission denied"
                Log.d("Ravi", "onRequestPermissionsResult: Location permission denied")
                Toast.makeText(this, "Location permission denied", Toast.LENGTH_SHORT).show()
            }
        }
    }
     fun returnCity(): String? {
         return city
     }

}