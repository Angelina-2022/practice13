package com.example.pr13

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import kotlin.math.sqrt

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Найти все необходимые элементы по их id
        val buttonCalculate = findViewById<Button>(R.id.calculate)
        val editTextNumber1 = findViewById<EditText>(R.id.editTextNumber1)
        val editTextNumber2 = findViewById<EditText>(R.id.editTextNumber2)
        val textViewResult1 = findViewById<TextView>(R.id.result1)
        val textViewResult2 = findViewById<TextView>(R.id.result2)
        val textViewResult3 = findViewById<TextView>(R.id.result3)

        // Определить действие при нажатии на кнопку
        buttonCalculate.setOnClickListener {
            // Получить значения из полей editTextNumber1 и editTextNumber2
            val number1String = editTextNumber1.text.toString()
            val number2String = editTextNumber2.text.toString()

            // Проверить, что поля editTextNumber1 и editTextNumber2 не пустые
            if (number1String.isBlank()) {
                Toast.makeText(this, "Введите первый катет!", Toast.LENGTH_SHORT).show()
                editTextNumber1.requestFocus()
                return@setOnClickListener
            }
            if (number2String.isBlank()) {
                Toast.makeText(this, "Введите второй катет!", Toast.LENGTH_SHORT).show()
                editTextNumber2.requestFocus()
                return@setOnClickListener
            }
                // Преобразовать значения из строк в числа
                val number1 = number1String.toFloat()
                val number2 = number2String.toFloat()

                // Выполнить вычисление и вывести результат
                //гипотенуза
                val gipoten = sqrt(number1 * number1 + number2 * number2)
                textViewResult1.text = gipoten.toString()
                //площадь
                 val ploshad = ( number1 * number2)/2
                textViewResult2.text = ploshad.toString()
                //периметр
                 val perimetr = number1 + number2 + gipoten
                 textViewResult3.text = perimetr.toString()
            }
        }
    }

