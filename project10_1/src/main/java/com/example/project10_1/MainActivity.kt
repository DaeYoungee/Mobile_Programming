package com.example.project10_1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.RadioButton
import android.widget.RadioGroup
import com.example.project10_1.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var btnNewActivity: Button
    private lateinit var radioGroupBtn: RadioGroup
    private lateinit var radioBtnSecond: RadioButton
    private lateinit var radioBtnThird: RadioButton
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        btnNewActivity = binding.btnNewActivity
        radioGroupBtn = binding.radioGroup
        radioBtnSecond = binding.radioSecondActivity
        radioBtnThird = binding.radioThirdActivity

        var choice: RadioButton? = null

        radioGroupBtn.setOnCheckedChangeListener { group, checkedId ->
            lateinit var intent: Intent
            when (checkedId) {
                radioBtnSecond.id -> {
                    choice = radioBtnSecond

                }
                radioBtnThird.id -> {
                    choice = radioBtnThird

                }
            }
        }

        btnNewActivity.setOnClickListener {
            choice?.let {
                when(it) {
                    radioBtnSecond -> {
                        intent = Intent(applicationContext, SecondActivity::class.java)
                        startActivity(intent)
                    }
                    radioBtnThird -> {
                        intent = Intent(applicationContext, ThirdActivity::class.java)
                        startActivity(intent)
                    }
                }
            }

        }



    }
}