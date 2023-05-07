package com.example.project10_1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.project10_1.databinding.ActivityMainBinding
import com.example.project10_1.databinding.ActivitySecondBinding

class SecondActivity : AppCompatActivity() {
    lateinit var btnReturn: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)

        btnReturn = binding.btnReturn
        btnReturn.setOnClickListener {
            finish()
        }
    }
}