package com.ankit.unitconverter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.EditText
import android.widget.Spinner
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    private lateinit var inputEditText: EditText
    private lateinit var outputTextView: TextView
    private lateinit var fromSpinner: Spinner
    private lateinit var toSpinner: Spinner

    private val units = arrayOf("meters", "kilometers", "gram", "centimeter", "kg")
    private val conversionFactors = arrayOf(1.0, 0.001,1.0 , 100.0, 0.001)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Initialize UI components
        inputEditText = findViewById(R.id.inputEditText)
        outputTextView = findViewById(R.id.outputTextView)
        fromSpinner = findViewById(R.id.fromSpinner)
        toSpinner = findViewById(R.id.toSpinner)

        // Set up spinners
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, units)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        fromSpinner.adapter = adapter
        toSpinner.adapter = adapter
    }

    fun onConvertClicked(view: View) {
        updateOutput()
    }

    private fun updateOutput() {
        val inputUnitIndex = fromSpinner.selectedItemPosition
        val outputUnitIndex = toSpinner.selectedItemPosition
        val input = inputEditText.text.toString().toDoubleOrNull() ?: 0.0
        val output = input * conversionFactors[inputUnitIndex] / conversionFactors[outputUnitIndex]
        outputTextView.text = output.toString()
    }
}
