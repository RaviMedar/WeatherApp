package com.ravi.weatherapp

import android.app.AlertDialog
import android.text.Editable
import android.view.LayoutInflater
import android.view.View
import android.widget.Button
import android.widget.EditText
import com.ravi.weatherapp.databinding.FragmentWeatherBinding
import com.ravi.weatherapp.view.MainActivity
import com.ravi.weatherapp.view.WeatherFragment
import com.ravi.weatherapp.viewModel.WeatherViewModel
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.Mockito.mock
import org.mockito.Mockito.verify
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class WeatherFragmentTest {

    @Mock
    lateinit var mockViewModel: WeatherViewModel

    @Mock
    lateinit var mockActivity: MainActivity

    @Mock
    lateinit var mockBinding: FragmentWeatherBinding

    private lateinit var weatherFragment: WeatherFragment

    @Before
    fun setup() {
        // Initialize the fragment
        weatherFragment = WeatherFragment()

        // Mock the activity returnCity method
        Mockito.`when`(mockActivity.returnCity()).thenReturn("TestCity")

        // Attach the fragment to the activity (this helps test lifecycle methods)
        weatherFragment.onAttach(mockActivity)
    }

    @Test
    fun `test onCreate should retrieve city from activity`() {
        // Call onCreate
        weatherFragment.onCreate(null)

        // Verify that myCity is set
        Assert.assertEquals("TestCity", weatherFragment.myCity)
    }

    @Test
    fun `test onCreateView should call getWeatherData on viewModel if city is not null`() {
        // Prepare the view for the fragment and set the binding
        weatherFragment._binding = mockBinding
        weatherFragment.myCity = "TestCity"

        // Set the mockViewModel in the fragment
        //weatherFragment.viewModel = mockViewModel

        // Simulate onCreateView
        weatherFragment.onCreateView(LayoutInflater.from(mockActivity), null, null)

        // Verify that the viewModel's getWeatherData is called with the city
        verify(mockViewModel).getWeatherData("TestCity")
    }

    @Test
    fun `test refresh button calls getWeatherData on click`() {
        // Simulate the city and the binding
        weatherFragment.myCity = "TestCity"
        val mockButton: Button = mock(Button::class.java)
        //Mockito.`when`(mockBinding.refreshButton).thenReturn(mockButton)

        // Simulate onViewCreated
        weatherFragment.onViewCreated(View(mockActivity), null)

        // Trigger button click
        mockButton.performClick()

        // Verify that the viewModel's getWeatherData is called when refreshButton is clicked
        verify(mockViewModel).getWeatherData("TestCity")
    }

    @Test
    fun `test showSearchDialog performs search and updates city`() {
        // Mock EditText and Button from dialog view
        val mockEditText = mock(EditText::class.java)
        Mockito.`when`(mockEditText.text).thenReturn(Editable.Factory.getInstance().newEditable("NewCity"))

        val mockSearchButton = mock(Button::class.java)
        val mockCancelButton = mock(Button::class.java)

        // Prepare the mock dialog view
        val mockDialogView = mock(View::class.java)
        Mockito.`when`(mockDialogView.findViewById<EditText>(R.id.editTextSearch)).thenReturn(mockEditText)
        Mockito.`when`(mockDialogView.findViewById<Button>(R.id.buttonSearch)).thenReturn(mockSearchButton)
        Mockito.`when`(mockDialogView.findViewById<Button>(R.id.buttonCancel)).thenReturn(mockCancelButton)

        // Mock AlertDialog Builder and Dialog
        val mockDialogBuilder = mock(AlertDialog.Builder::class.java)
        val mockDialog = mock(AlertDialog::class.java)
        Mockito.`when`(mockDialogBuilder.create()).thenReturn(mockDialog)

        // Mock LayoutInflater
        val mockLayoutInflater = mock(LayoutInflater::class.java)
        Mockito.`when`(mockLayoutInflater.inflate(R.layout.dialog_layout, null)).thenReturn(mockDialogView)

        // Simulate the showSearchDialog call
        weatherFragment.showSearchDialog()

        // Simulate search button click
        mockSearchButton.performClick()

        // Verify that performSearch was called with "NewCity"
        Assert.assertEquals("NewCity", weatherFragment.myCity)
    }

    @Test
    fun `test performSearch updates city and calls getWeatherData`() {
        // Simulate search
        weatherFragment.performSearch("NewCity")

        // Verify that city is updated
        Assert.assertEquals("NewCity", weatherFragment.myCity)

        // Verify that viewModel's getWeatherData is called with the new city
        verify(mockViewModel).getWeatherData("NewCity")
    }
}
