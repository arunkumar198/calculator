package com.rcd.calculaterapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    var usInput: TextView? = null
    var dote: TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        usInput = findViewById(R.id.display)
        dote = findViewById(R.id.dot)
    }

    fun onDigit(view: View) {
        usInput?.append((view as Button).text)
    }

    fun cancel(cancel: View) {
        usInput?.text = ""
        dote?.isClickable = true
    }

    fun dot(dot: View) {
        usInput?.append((dot as Button).text)
        dote?.isClickable = false
    }

    fun delete(view: View) {
        usInput?.text = usInput?.text?.dropLast(1)
    }

    fun operator(operator: View) {
        usInput?.append((operator as Button).text)
        dote?.isClickable = true
    }

    fun remove0valAtEndIndex(answer: Double): String {
        var result = answer.toString()
        if (result.substring(result.length - 2, result.length) == ".0") {
            return result.substring(0, result.length - 2)
        } else {
            return result
        }
    }

    fun equal(equal: View) {
        var userVal = (usInput?.text).toString()
        var prefix = ""
        if (userVal.startsWith("-")) {
            prefix = "-"
            userVal = userVal.substring(1)
        }

        when {
            userVal.contains("+") -> {
                val userInput = userVal.split("+")
                var firstVal = userInput[0]
                if (prefix == "-") {
                    firstVal = prefix + userInput[0]
                }
                val output = firstVal.toDouble() + userInput[1].toDouble()
                usInput?.text = remove0valAtEndIndex(output)
            }
            userVal.contains("-") -> {
                val userInput = userVal.split("-")
                var firstVal = userInput[0]
                if (prefix == "-") {
                    firstVal = prefix + userInput[0]
                }
                val output = firstVal.toDouble() - userInput[1].toDouble()
                usInput?.text = remove0valAtEndIndex(output)
            }
            userVal.contains("*") -> {
                val userInput = userVal.split("*")
                var firstVal = userInput[0]
                if (prefix == "-") {
                    firstVal = prefix + userInput[0]
                }
                val output = firstVal.toDouble() * userInput[1].toDouble()
                usInput?.text = remove0valAtEndIndex(output)
            }
            userVal.contains("/") -> {
                val userInput = userVal.split("/")
                var firstVal = userInput[0]
                if (prefix == "-") {
                    firstVal = prefix + userInput[0]
                }
                val output = firstVal.toDouble() / userInput[1].toDouble()
                usInput?.text = remove0valAtEndIndex(output)
            }
        }
    }

    fun root(root: View) {
        var userVal = (usInput?.text).toString()
        var prefix = ""
        if (userVal.startsWith("-")) {
            prefix = "-"
            userVal = userVal.substring(1)
        }
        var firstVal = userVal
        if (prefix == "-") {
            firstVal = prefix + firstVal
        }
        val output = firstVal.toDouble() * firstVal.toDouble()
        usInput?.text = remove0valAtEndIndex(output)
    }
}
