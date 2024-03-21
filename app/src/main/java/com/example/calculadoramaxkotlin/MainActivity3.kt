package com.example.calculadoramaxkotlin

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity3 : AppCompatActivity(), View.OnClickListener {

    private lateinit var tvDisplay: TextView
    private var currentNumber = StringBuilder()
    private var currentOperator: Char = ' '
    private var operand1: Double = 0.0
    private var operand2: Double = 0.0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main3)

        // Inicializar los elementos de la interfaz de usuario
        tvDisplay = findViewById(R.id.tvDisplay)

        // Configurar los listeners de los botones
        val buttons = listOf<Button>(
            findViewById(R.id.btn0),
            findViewById(R.id.btn1),
            findViewById(R.id.btn2),
            findViewById(R.id.btn3),
            findViewById(R.id.btn4),
            findViewById(R.id.btn5),
            findViewById(R.id.btn6),
            findViewById(R.id.btn7),
            findViewById(R.id.btn8),
            findViewById(R.id.btn9),
            findViewById(R.id.btnDot),
            findViewById(R.id.btnClear),
            findViewById(R.id.btnDivide),
            findViewById(R.id.btnPlus),
            findViewById(R.id.btnMinus),
            findViewById(R.id.btnMultiply),
            findViewById(R.id.btnEquals),
            findViewById(R.id.btnFactorial),
            findViewById(R.id.btnFibonacci),
            findViewById(R.id.backButton)
        )

        for (button in buttons) {
            button.setOnClickListener(this)
        }
    }

    override fun onClick(view: View?) {
        when (view?.id) {
            R.id.btn0, R.id.btn1, R.id.btn2, R.id.btn3, R.id.btn4,
            R.id.btn5, R.id.btn6, R.id.btn7, R.id.btn8, R.id.btn9,
            R.id.btnDot -> appendNumber(view as Button)
            R.id.btnClear -> clearDisplay()
            R.id.btnDivide, R.id.btnPlus, R.id.btnMinus, R.id.btnMultiply -> setOperator(view as Button)
            R.id.btnEquals -> calculateResult()
            R.id.btnFactorial -> calculateFactorial()
            R.id.btnFibonacci -> calculateFibonacci()
            R.id.backButton -> finish() // Botón para volver a la página anterior
        }
    }

    private fun appendNumber(button: Button) {
        currentNumber.append(button.text)
        updateDisplay()
    }

    private fun clearDisplay() {
        currentNumber.clear()
        operand1 = 0.0
        operand2 = 0.0
        currentOperator = ' '
        updateDisplay()
    }

    private fun setOperator(button: Button) {
        if (currentNumber.isNotEmpty()) {
            operand1 = currentNumber.toString().toDouble()
            currentNumber.clear()
            currentOperator = button.text[0]
            updateDisplay()
        }
    }

    private fun calculateResult() {
        if (currentNumber.isNotEmpty() && currentOperator != ' ') {
            operand2 = currentNumber.toString().toDouble()
            val result = when (currentOperator) {
                '+' -> Calculadora.suma(operand1, operand2)
                '-' -> Calculadora.resta(operand1, operand2)
                '*' -> Calculadora.multiplicacion(operand1, operand2)
                '/' -> Calculadora.division(operand1, operand2)
                else -> 0.0
            }
            currentNumber.clear()
            currentNumber.append(result)
            updateDisplay()
            operand1 = result
            currentOperator = ' '
        }
    }

    private fun calculateFactorial() {
        if (currentNumber.isNotEmpty()) {
            val number = currentNumber.toString().toInt()
            val factorial = Calculadora.factorial(number)
            currentNumber.clear()
            currentNumber.append(factorial)
            updateDisplay()
        }
    }

    private fun calculateFibonacci() {
        if (currentNumber.isNotEmpty()) {
            val number = currentNumber.toString().toInt()
            val fibonacci = Calculadora.fibonacci(number)
            currentNumber.clear()
            currentNumber.append(fibonacci)
            updateDisplay()
        }
    }

    private fun updateDisplay() {
        tvDisplay.text = currentNumber.toString()
    }
}
