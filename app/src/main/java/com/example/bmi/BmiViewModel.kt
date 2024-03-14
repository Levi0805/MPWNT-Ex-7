package com.example.bmi

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class BmiViewModel: ViewModel() {
    var heightInput: String by mutableStateOf( " ")
    var weightInput: String by mutableStateOf( " ")

    var bmi: Float = 0.0f
        get() {
            return calculateBmi(multiplier = 1.0f)
        }

    fun changeWeightInput(value: String){
        weightInput = value
    }

    fun changeHeightInput(value: String){
        heightInput = value
    }

    private var weight: Int = 0
        get() {
            return weightInput.toIntOrNull() ?: 0
        }

    private var height: Int = 0
        get() {
            return heightInput.toIntOrNull() ?: 0
        }
    private fun calculateBmi(multiplier: Float): Float {
        return if (weight > 0 && height >0 ) (weight / (height * height))*multiplier else 0.0f
    }
}