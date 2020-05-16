package com.example.calculatorsimp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import net.objecthunter.exp4j.ExpressionBuilder

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        Keypad Buttons
        one.setOnClickListener {
             evaluateExpression("1",clear = true)
        }

        two.setOnClickListener {
            evaluateExpression("2",clear = true)
        }

        three.setOnClickListener {
            evaluateExpression("3",clear = true)
        }

        four.setOnClickListener {
            evaluateExpression("4",clear = true)
        }

        five.setOnClickListener {
            evaluateExpression("5",clear = true)
        }

        six.setOnClickListener {
            evaluateExpression("6",clear = true)
        }

        seven.setOnClickListener {
            evaluateExpression("7",clear = true)
        }

        eight.setOnClickListener {
            evaluateExpression("8",clear = true)
        }

        nine.setOnClickListener {
            evaluateExpression("9",clear = true)
        }

        zero.setOnClickListener {
            evaluateExpression("0",clear = true)
        }



//        Arithmetic Operators Buttons
        add.setOnClickListener {
            evaluateExpression("+",clear = true)
        }

        minus.setOnClickListener {
            evaluateExpression("-",clear = true)
        }

        multiply.setOnClickListener {
            evaluateExpression("*",clear = true)
        }

        divide.setOnClickListener {
            evaluateExpression("/",clear = true)
        }

        dot.setOnClickListener {
            evaluateExpression(".",clear = true)
        }

//        Clear Button
        clear.setOnClickListener {
            workspace.text = ""
            answer.text = ""
        }

//        Equals Button
        equals.setOnClickListener{
            val text = workspace.text.toString()
            val work = ExpressionBuilder(text).build()

            val result = work.evaluate()
            val longanswer = result.toLong()
            if(result == longanswer.toDouble()) {
                answer.text = longanswer.toString()
            }else {
                answer.text = result.toString()
            }
        }

//        Back / Delete Button
        delete.setOnClickListener{
            val text = workspace.text.toString()
            if(text.isNotEmpty()){
                workspace.text = text.drop(1)
            }

            answer.text = ""
        }
    }


    //        Function to calcutate the arithmetic and logical operations using Expresion Builder Library
    private fun evaluateExpression(s: String, clear: Boolean) {
        if(clear){
            answer.text = ""
            workspace.append(s)
        }else {
            workspace.append(answer.text)
            workspace.append(s)
            answer.text = ""
        }
    }
}
