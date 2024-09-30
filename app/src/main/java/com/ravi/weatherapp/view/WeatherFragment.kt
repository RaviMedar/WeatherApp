package com.ravi.weatherapp.view

import android.app.AlertDialog
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.annotation.VisibleForTesting
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.ravi.weatherapp.R
import com.ravi.weatherapp.databinding.FragmentWeatherBinding
import com.ravi.weatherapp.viewModel.WeatherViewModel


class WeatherFragment : Fragment() {

    @VisibleForTesting(otherwise = VisibleForTesting.PRIVATE)
    var _binding: FragmentWeatherBinding? = null
    private val binding get() = _binding!!

    @VisibleForTesting(otherwise = VisibleForTesting.PRIVATE)
    val viewModel: WeatherViewModel by activityViewModels()

    @VisibleForTesting(otherwise = VisibleForTesting.PRIVATE)
    var myCity: String? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val activity: MainActivity? = activity as MainActivity?
        myCity= activity?.returnCity()

    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentWeatherBinding.inflate(inflater, container, false)
        binding.lifecycleOwner = this
        viewModel.resetBackground()
        myCity?.let { viewModel.getWeatherData(it) }
        binding.viewModel = viewModel
        viewModel.statusBarColor.observe(viewLifecycleOwner) { color ->
            activity?.window?.statusBarColor = resources.getColor(color, activity?.theme)
        }

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // find the views
        val refreshButton = binding.refreshButton
        val searchButton = binding.searchButton
        val cityButton = binding.cityButton


        refreshButton.setOnClickListener {
            myCity?.let { it1 -> viewModel.getWeatherData(it1) }
        }
        cityButton.setOnClickListener {
            //navigateToSearchFragment()
        }

        searchButton.setOnClickListener {
            showSearchDialog()
        }

       cityButton.text = "City: ${this.myCity}".uppercase()


    }


    @VisibleForTesting(otherwise = VisibleForTesting.PRIVATE)
    fun showSearchDialog() {
        // Inflate the dialog layout
        val dialogView = layoutInflater.inflate(R.layout.dialog_layout, null)
        val editTextSearch = dialogView.findViewById<EditText>(R.id.editTextSearch)

        // Build the dialog
        val dialogBuilder = AlertDialog.Builder(requireContext())
            .setTitle("Search")
            .setView(dialogView)
            .setCancelable(true)

        // Create the dialog
        val dialog = dialogBuilder.create()

        // Handle Cancel button
        dialogView.findViewById<Button>(R.id.buttonCancel).setOnClickListener {
            dialog.dismiss() // Close the dialog
        }

        // Handle Search button
        dialogView.findViewById<Button>(R.id.buttonSearch).setOnClickListener {
            val searchTerm: String = editTextSearch.text.toString()
            // Implement  search logic here
            Log.d("Ravi", "showSearchDialog: $searchTerm")
            performSearch(searchTerm)
            dialog.dismiss() // Close the dialog after search
        }

        dialog.show() // Show the dialog
    }

    @VisibleForTesting(otherwise = VisibleForTesting.PRIVATE)
    fun performSearch(searchTerm: String) {
       if (searchTerm.isNotEmpty()){
           myCity = searchTerm
           myCity?.let { viewModel.getWeatherData(it) }
           binding.cityButton.text = "City: $searchTerm".uppercase()
       }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }


}