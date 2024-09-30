package com.ravi.weatherapp


import android.content.pm.PackageManager
import android.location.Address
import android.location.Geocoder
import android.location.Location
import android.os.Build
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationServices
import com.ravi.weatherapp.view.MainActivity
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test
import org.mockito.Mockito.*
import java.io.IOException

class MainActivityUnitTest {

    private lateinit var mainActivity: MainActivity
    private lateinit var mockFusedLocationClient: FusedLocationProviderClient
    private lateinit var mockGeocoder: Geocoder

    @Before
    fun setUp() {
        mainActivity = MainActivity()
        mockFusedLocationClient = mock(FusedLocationProviderClient::class.java)
        mockGeocoder = mock(Geocoder::class.java)

        // Set the mock location client in MainActivity
        mainActivity.fusedLocationClient = mockFusedLocationClient
    }

    @Test
    fun testGetCityName_Success() {
        // Arrange: mock Geocoder to return a valid city name
        val mockAddress = mock(Address::class.java)
        `when`(mockAddress.locality).thenReturn("New York")
        `when`(mockGeocoder.getFromLocation(anyDouble(), anyDouble(), anyInt())).thenReturn(listOf(mockAddress))

        // Act: Call getCityName with mock latitude/longitude
        mainActivity.getCityName(40.7128, -74.0060)

        // Assert: Verify that the city was updated
        assertEquals("New York", mainActivity.returnCity())
    }

    @Test
    fun testGetCityName_FallbackToAdminArea() {
        // Arrange: mock Geocoder with no locality but with admin area
        val mockAddress = mock(Address::class.java)
        `when`(mockAddress.locality).thenReturn(null)
        `when`(mockAddress.subAdminArea).thenReturn(null)
        `when`(mockAddress.adminArea).thenReturn("New York State")
        `when`(mockGeocoder.getFromLocation(anyDouble(), anyDouble(), anyInt())).thenReturn(listOf(mockAddress))

        // Act: Call getCityName with mock latitude/longitude
        mainActivity.getCityName(40.7128, -74.0060)

        // Assert: Check that the fallback to admin area occurred
        assertEquals("New York State", mainActivity.returnCity())
    }

    @Test
    fun testGetCityName_GeocoderFailure() {
        // Arrange: mock Geocoder to throw IOException
        `when`(mockGeocoder.getFromLocation(anyDouble(), anyDouble(), anyInt())).thenThrow(
            IOException::class.java)

        // Act: Call getCityName
        mainActivity.getCityName(40.7128, -74.0060)

        // Assert: Ensure city remains null after failure
        assertNull(mainActivity.returnCity())
    }

    @Test
    fun testOnRequestPermissionsResult_PermissionGranted() {
        // Arrange: mock permission request
        val permissions = arrayOf(android.Manifest.permission.ACCESS_FINE_LOCATION)
        val grantResults = intArrayOf(PackageManager.PERMISSION_GRANTED)

        // Act: Call onRequestPermissionsResult
        mainActivity.onRequestPermissionsResult(1, permissions, grantResults)

        // Assert: Verify that getCurrentLocation was called (this requires a spy on the method if internal logic)
        // In actual test, you may mock or spy getCurrentLocation()
    }

    @Test
    fun testOnRequestPermissionsResult_PermissionDenied() {
        // Arrange: mock permission request
        val permissions = arrayOf(android.Manifest.permission.ACCESS_FINE_LOCATION)
        val grantResults = intArrayOf(PackageManager.PERMISSION_DENIED)

        // Act: Call onRequestPermissionsResult
        mainActivity.onRequestPermissionsResult(1, permissions, grantResults)

        // Assert: Check appropriate handling when permission is denied
        // You can spy or check logs, to ensure correct behavior is followed
    }
}
