package com.example.itelisman.calculator

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    var operation = "*"
    var oldNumber = ""
    var isNewOperation = true
    var isNegActive = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun buttonNumberEvent(view: View){
        if(isNewOperation){
            editTextShowNumber.setText("")
        }
        isNewOperation = false

        val buttonSelected = view as Button
        var numberSelected:String = editTextShowNumber.text.toString()
        when(buttonSelected.id){
            buttonZero.id->{
                numberSelected += "0"
            }
            buttonOne.id->{
                numberSelected += "1"
            }
            buttonTwo.id->{
                numberSelected += "2"
            }
            buttonThree.id->{
                numberSelected += "3"
            }
            buttonFour.id->{
                numberSelected += "4"
            }
            buttonFive.id->{
                numberSelected += "5"
            }
            buttonSix.id->{
                numberSelected += "6"
            }
            buttonSeven.id->{
                numberSelected += "7"
            }
            buttonEight.id->{
                numberSelected += "8"
            }
            buttonNine.id->{
                numberSelected += "9"
            }
            buttonPlusMinus.id->{
                if(!isNegActive && numberSelected!="0"){
                    numberSelected = "-" + numberSelected
                    isNegActive = true
                } else {
                    numberSelected = numberSelected.replace("-", "")
                    isNegActive = false
                }
            }
            buttonDecimal.id->{
                if(!numberSelected.contains(".")){
                    numberSelected += "."
                }
            }
            buttonClear.id->{
                numberSelected = "0"
            }
        }

        editTextShowNumber.setText(numberSelected)
    }

    fun buttonClickOperation(view:View){
        val buttonSelected = view as Button

        var numberSelected:String = editTextShowNumber.text.toString()
        when(buttonSelected.id){
            buttonDivide.id->{
                operation = "/"
            }
            buttonMultiplication.id->{
                operation = "*"
            }
            buttonSubtract.id->{
                operation = "-"
            }
            buttonPlus.id->{
                operation = "+"
            }
            buttonPercent.id->{
                numberSelected = (numberSelected.toDouble() / 100).toString()
                editTextShowNumber.setText(numberSelected)
            }
        }
        oldNumber=editTextShowNumber.text.toString()
        isNewOperation = true

    }

    fun clickEquals(view:View){
        val newNumber = editTextShowNumber.text.toString()
        var finalNumber:Double?=null
        when(operation){
            "/"->{
                finalNumber = oldNumber.toDouble() / newNumber.toDouble()
            }
            "*"->{
                finalNumber = oldNumber.toDouble() * newNumber.toDouble()
            }
            "-"->{
                finalNumber = oldNumber.toDouble() - newNumber.toDouble()
            }
            "+"->{
                finalNumber = oldNumber.toDouble() + newNumber.toDouble()
            }
        }

        editTextShowNumber.setText(finalNumber.toString())
        isNewOperation = true
    }
}
