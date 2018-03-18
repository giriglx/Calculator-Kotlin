package com.example.giri.calculator_kotlin

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

//    private var input: EditText?=null
//    private var output: TextView?=null
//    private var symbols: EditText?=null
    private var pendingOperation = "="
    private var operand1: Double? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
//        input=findViewById(R.id.output_text)
//        output=findViewById(R.id.tvOutput)
//        symbols=findViewById(R.id.etSign)
        val one:Button=findViewById(R.id.one)
        val two:Button=findViewById(R.id.two)
        val three:Button=findViewById(R.id.three)
        val four:Button=findViewById(R.id.fore)
        val five:Button=findViewById(R.id.five)
        val six:Button=findViewById(R.id.six)
        val seven:Button=findViewById(R.id.seven)
        val eight:Button=findViewById(R.id.eight)
        val nine:Button=findViewById(R.id.nine)
        val zero:Button=findViewById(R.id.zero)
        val dot:Button=findViewById(R.id.dot)
        val add=findViewById<Button>(R.id.add)
        val minus=findViewById<Button>(R.id.minus)
        val div=findViewById<Button>(R.id.div)
        val equal=findViewById<Button>(R.id.equal)
        val multiply=findViewById<Button>(R.id.multiply)


        val listener= View.OnClickListener { v->
            val b = v as Button
            etSign.append(b.text)
        }
        one.setOnClickListener(listener)
        two.setOnClickListener(listener)
        three.setOnClickListener(listener)
        four.setOnClickListener(listener)
        five.setOnClickListener(listener)
        six.setOnClickListener(listener)
        seven.setOnClickListener(listener)
        eight.setOnClickListener(listener)
        nine.setOnClickListener(listener)
        zero.setOnClickListener(listener)
        dot.setOnClickListener(listener)

        val opListener = View.OnClickListener { v ->
            val op = (v as Button).text.toString()
            try {
                val value = etSign.text.toString().toDouble()
                performOperation(value, op)
            } catch (e: NumberFormatException) {
                etSign.setText("")
            }
            pendingOperation = op
            tvOutput.text = pendingOperation
        }
        equal.setOnClickListener(opListener)
        div.setOnClickListener(opListener)
        add.setOnClickListener(opListener)
        minus.setOnClickListener(opListener)
        multiply.setOnClickListener(opListener)



    }
    private fun performOperation(value: Double, operation: String) {
        if (operand1 == null) {
            operand1 = value
        } else {
            if (pendingOperation == "=") {
                pendingOperation = operation
            }

            when (pendingOperation) {
                "=" -> operand1 = value
                "/" -> operand1 = if (value == 0.0) {
                    Double.NaN   // handle attempt to divide by zero
                } else {
                    operand1!! / value
                }
                "*" -> operand1 = operand1!! * value
                "-" -> operand1 = operand1!! - value
                "+" -> operand1 = operand1!! + value
            }
        }
        output_text.setText(operand1.toString())
        etSign.setText("")
    }
        }
