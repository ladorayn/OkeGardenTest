package com.lado.okegardentest

import android.os.Bundle
import android.util.Log
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity


class ResultActivity : AppCompatActivity() {
    private lateinit var celcius: EditText
    private lateinit var fahrenheit: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.result)

        val intent = intent

        val c = intent.getStringExtra("c")
        val f = intent.getStringExtra("f")

        print("-----------------")
        print(c)
        print(f)

        celcius = findViewById(R.id.textInput2)
        fahrenheit = findViewById(R.id.textInput3)

        celcius.setText(c)
        fahrenheit.setText(f)

        celcius.isFocusable = false
        fahrenheit.isFocusable = false


    }
}