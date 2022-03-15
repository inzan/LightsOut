package com.zybooks.lightsout

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.RadioButton
import androidx.appcompat.app.AppCompatActivity

const val EXTRA_COLOR = "com.zybooks.lightsout.color"

class ColorActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_color)
        // Get the color ID from MainActivity
        val colorId = intent.getIntExtra(EXTRA_COLOR, R.color.yellow)

        // Select the radio button matching the color ID
        val radioId = when (colorId) {
            R.color.red -> R.id.radio_red
            R.color.orange -> R.id.radio_orange
            R.color.green -> R.id.radio_green
            else -> R.id.radio_yellow
        }

        val radioButton = findViewById<RadioButton>(radioId)
        radioButton.isChecked = true
    }

    fun onColorSelected(view: View) {
        val colorId = when (view.id) {
            R.id.radio_red -> R.color.red
            R.id.radio_orange -> R.color.orange
            R.id.radio_green -> R.color.green
            else -> R.color.yellow
        }

        val dataIntent = Intent()
        dataIntent.putExtra(EXTRA_COLOR, colorId)
        setResult(RESULT_OK, dataIntent)
        finish()
    }
}