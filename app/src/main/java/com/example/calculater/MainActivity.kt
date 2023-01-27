package com.example.calculater

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun buClick(view: View) {

        if(isNewop){
            edittxt.setText("")
        }
        isNewop= false
        val buSelect = view as Button
        var buClickval : String = edittxt.text.toString()

        when(buSelect.id){

            but0.id -> buClickval += "0"
            but1.id -> buClickval += "1"
            but2.id -> buClickval += "2"
            but3.id -> buClickval += "3"
            but4.id -> buClickval += "4"
            but5.id -> buClickval += "5"
            but6.id -> buClickval += "6"
            but7.id -> buClickval += "7"
            but8.id -> buClickval += "8"
            but9.id -> buClickval += "9"
            butdot.id -> buClickval += "."
            butpm.id -> {
                buClickval = "-" + buClickval
            }

        }

        edittxt.setText(buClickval)
    }
var op = ""
    var oldnum = ""
    var isNewop = true

    fun buOp(view: View) {

        val buSelect = view as Button

        when(buSelect.id) {

            buMul.id -> op = "x"
            buDiv.id -> op = "/"
            buAdd.id -> op = "+"
            buMin.id -> op = "-"
        }
        oldnum = edittxt.text.toString()
        isNewop=true
    }

    fun buEqual(view: View) {

        val newNum = edittxt.text.toString()
        var finalNum :Double? = null
        when(op){
           "x"->{
              finalNum = oldnum.toDouble() *newNum.toDouble()
           }
            "/"->{
                finalNum = oldnum.toDouble() /newNum.toDouble()
               }
            "+"->{
                finalNum = oldnum.toDouble() +newNum.toDouble()
            }
            "-"->{
                finalNum = oldnum.toDouble() -newNum.toDouble()
            }

        }

        edittxt.setText(finalNum.toString())
        isNewop=true
    }

    fun buCleanit(view: View) {

        edittxt.setText("0")
        isNewop=true
    }
    fun buPercent(view: View) {

        var num:Double = edittxt.text.toString().toDouble() /100
        edittxt.setText(num.toString())
    }


}