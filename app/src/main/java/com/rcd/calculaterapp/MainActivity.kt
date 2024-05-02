package com.rcd.calculaterapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast




class MainActivity : AppCompatActivity() {
    var usInput: TextView? = null
    var dote : TextView? = null
    var remove : TextView? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        usInput  = findViewById(R.id.display)
        dote=findViewById(R.id.dot)
        remove=findViewById(R.id.rougn)
    }

    fun onDigit(view: View){
        Toast.makeText(this, "Button - ${(view as Button).text} Tapped", Toast.LENGTH_LONG).show()
        usInput?.append(view.text)
    }

    fun cancel(cancel: View){
        Toast.makeText(this, "Button - ${(cancel as Button).text}ancel Tapped", Toast.LENGTH_LONG).show()
        usInput?.text=""
        dote?.isClickable = true
    }

    fun dot(dot:View){
        Toast.makeText(this, "Button - ${(dot as Button).text} Tapped", Toast.LENGTH_LONG).show()
        usInput?.append(dot.text)
        dote?.isClickable = false
    }

    fun delete(view: View) {
        usInput?.text.toString()
        usInput?.text= usInput?.text?.dropLast(1)
    }

    fun operator(operator:View){
        Toast.makeText(this, "Button - ${(operator as Button).text} Tapped", Toast.LENGTH_LONG).show()
        usInput?.append(operator.text)
        dote?.isClickable = true
    }


    fun remove0valAtEndIndex(answer:Double): String{

        var result = answer.toString()

        if(result.substring(result.length - 2, result.length) == ".0")
        {
            return result.substring(0, result.length - 2)
        }
        else
        {
            return result
        }

    }

    fun equal(equal:View){

        var userVal = (usInput?.text).toString()
        var prefix = ""
        if(userVal.startsWith("-")){
            prefix = "-"
            userVal=userVal.substring(1)
        }

        if(userVal.contains("+")) {
            var userInput = userVal.split("+")

            var firstVal = userInput[0]
            if(prefix=="-"){
                firstVal=prefix+userInput[0]
            }
            var output = firstVal.toDouble() + userInput[1].toDouble()
            usInput?.text = remove0valAtEndIndex(output)

        }


        else if(userVal.contains("-")) {
            var userInput = userVal.split("-")
            var firstVal = userInput[0]
            if(prefix=="-"){
                firstVal=prefix+userInput[0]
            }
            var output = firstVal.toDouble() - userInput[1].toDouble()
            usInput?.text = remove0valAtEndIndex(output)
        }


        else if(userVal.contains("*")) {
            var userInput = userVal.split("*")
            var firstVal = userInput[0]
            if(prefix=="-"){
                firstVal=prefix+userInput[0]
            }
            var output = firstVal.toDouble() * userInput[1].toDouble()
            usInput?.text = remove0valAtEndIndex(output)
        }


        else if(userVal.contains("/")) {
            var userInput = userVal.split("/")
            var firstVal = userInput[0]
            if(prefix=="-"){
                firstVal=prefix+userInput[0]
            }
            var output = firstVal.toDouble() / userInput[1].toDouble()
            usInput?.text = remove0valAtEndIndex(output)
        }




    }

    fun root(root:View){
        var userVal = (usInput?.text).toString()
        var prefix = ""
        if(userVal.startsWith("-")){
            prefix = "-"
            userVal=userVal.substring(1)
        }
        var firstVal = userVal
        if(prefix=="-"){
            firstVal=prefix+firstVal
        }
        var output = firstVal.toDouble() * firstVal.toDouble()
        usInput?.text = remove0valAtEndIndex(output)


    }


}
















