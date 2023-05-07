package com.example.mobileprograming

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import com.example.mobileprograming.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var btnNewActivity:Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        btnNewActivity = binding.btnNewActivity

        btnNewActivity.setOnClickListener {
            var intent = Intent(applicationContext, SecondActivity::class.java)
            startActivity(intent)
        }

    }
}