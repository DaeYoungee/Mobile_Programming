package com.example.calculate

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.MotionEvent
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.example.calculate.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var edit1: EditText
    lateinit var edit2: EditText
    lateinit var btnAdd: Button
    lateinit var btnSub: Button
    lateinit var btnMul: Button
    lateinit var btnDiv: Button
    lateinit var textResult: TextView
    lateinit var num1: String
    lateinit var num2: String
    var result: Int? = null


    @SuppressLint("SetTextI18n", "ClickableViewAccessibility")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        title = "계산기"

        edit1 = binding.edit1
        edit2 = binding.edit2
        textResult = binding.textResult


        val btnNum: List<Button> = listOf(
            binding.btn1,
            binding.btn2,
            binding.btn3,
            binding.btn4,
            binding.btn5,
            binding.btn6,
            binding.btn7,
            binding.btn8,
            binding.btn9,
            binding.btn0
        )
        val btnOperation: List<Button> = listOf(
            binding.btnAdd,
            binding.btnSub,
            binding.btnMul,
            binding.btnDiv
        )

        btnNum.forEach { number ->
            number.setOnClickListener {
                if (edit1.isFocused) {
                    edit1.setText(edit1.text.toString() + number.text.toString())
                } else if (edit2.isFocused) {
                    edit2.setText(edit2.text.toString() + number.text.toString())
                } else {
                    Toast.makeText(this, "focus가 되지 않았습니다.", Toast.LENGTH_SHORT).show()
                }
            }
        }

        btnOperation.forEach { operation ->
            operation.setOnTouchListener { _, event ->
                num1 = binding.edit1.text.toString()
                num2 = binding.edit2.text.toString()
                when (event.action) {
                    MotionEvent.ACTION_DOWN -> {
                        Log.d("daeYoung", "btn: ${operation.text}")
                        when (operation.text) {
                            "+" -> {
                                result = num1.toInt() + num2.toInt()
                                edit1.text.clear()
                                edit2.text.clear()
                                textResult.text = result.toString()
                            }
                            "-" -> {
                                result = num1.toInt() - num2.toInt()
                                edit1.text.clear()
                                edit2.text.clear()
                                textResult.text = result.toString()
                            }
                            "*" -> {
                                result = num1.toInt() * num2.toInt()
                                edit1.text.clear()
                                edit2.text.clear()
                                textResult.text = result.toString()
                            }
                            "/" -> {
                                if (num2 == "0") {
                                    result = 0
                                    Toast.makeText(this, "0으로 나눌 수 없음", Toast.LENGTH_SHORT).show()
                                } else {
                                    result = num1.toInt() / num2.toInt()
                                }
                                edit1.text.clear()
                                edit2.text.clear()
                                textResult.text = result.toString()
                            }
                        }
                        false
                    }
                    else -> {
                        false
                    }
                }

            }
        }
    }
}