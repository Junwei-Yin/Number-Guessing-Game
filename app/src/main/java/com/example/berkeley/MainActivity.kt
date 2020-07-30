package com.example.berkeley

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import java.util.*

class MainActivity : AppCompatActivity() {
    private var points = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        pickRandomNumbers()
    }

    fun leftButtonClick(view: View) {
        checkIfCorrect(true)
    }

    fun rightButtonClick(view: View) {
        checkIfCorrect(false)
    }

    private fun checkIfCorrect(isLeft: Boolean) {
        val leftButton = findViewById<Button>(R.id.left_button)
        val rightButton = findViewById<Button>(R.id.right_button)

        val leftNum = leftButton.text.toString().toInt()
        val rightNum = rightButton.text.toString().toInt()

        if ((isLeft && leftNum > rightNum) || (!isLeft &&  leftNum < rightNum)) {
            points++
            Toast.makeText(this, "You got it right!", Toast.LENGTH_SHORT).show()
        }
        else {
            points--
            Toast.makeText(this, "UC Davis still takes you.", Toast.LENGTH_SHORT).show()
        }

        val point_view = findViewById<TextView>(R.id.points_view)
        point_view.text = "Points: $points"

        pickRandomNumbers()
    }

    private fun pickRandomNumbers() {
        val leftButton = findViewById<Button>(R.id.left_button)
        val rightButton = findViewById<Button>(R.id.right_button)

        val r = Random()
        val num1 = r.nextInt(10)

        var num2 = num1
        while (num2 == num1) {
            num2 = r.nextInt(10)
        }

        leftButton.text = "$num1"
        rightButton.text = "$num2"
    }
}
