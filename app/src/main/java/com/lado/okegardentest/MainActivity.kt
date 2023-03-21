package com.lado.okegardentest

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.Spinner
import androidx.appcompat.app.AppCompatActivity
import android.view.View
import android.widget.EditText
import android.widget.ProgressBar
import android.widget.Toast
import com.lado.okegardentest.viewmodel.WeatherViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var weatherViewModel: WeatherViewModel

    private lateinit var progressBar: ProgressBar
    private lateinit var city: Spinner
    private lateinit var apiKey: EditText
    private lateinit var submitButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.hide()

/*      To Run Second Section, change value run_first_section to false
*/

        val run_first_section = true

        if (run_first_section) {
            setContentView(R.layout.activity_main)
            submitButton = findViewById(R.id.button)
            apiKey = findViewById(R.id.textInput)
            city = findViewById(R.id.spinner)
            weatherViewModel = WeatherViewModel()
            subscribe()
            progressBar = findViewById(R.id.progress_loader)

            submitButton.setOnClickListener {

                weatherViewModel.getWeatherData(apiKey = apiKey.text.toString(), city = city.selectedItem.toString())

            }
        } else {
            setContentView(R.layout.second_layout)
        }

    }

    private fun subscribe() {
        weatherViewModel.isLoading.observe(this) { isLoading ->
            // Set the result text to Loading
            if (isLoading) progressBar.visibility = View.VISIBLE }

        weatherViewModel.isError.observe(this) { isError ->
            // Hide display image and set the result text to the error message
            if (isError) {
                progressBar.visibility = View.GONE
                Toast.makeText(this, "Error occurred", Toast.LENGTH_SHORT).show()
            }
        }
        weatherViewModel.weatherData.observe(this) { weatherData ->
            // Display weather data to the UI
            progressBar.visibility = View.GONE
            val intent = Intent(this, ResultActivity::class.java)
            intent.putExtra("c", weatherData.current?.temp_c.toString())
            intent.putExtra("f", weatherData.current?.temp_f.toString())
            startActivity(intent)
        }
    }
}