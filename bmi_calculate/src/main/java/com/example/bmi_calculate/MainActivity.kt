package com.example.bmi_calculate

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.preference.PreferenceManager
import android.widget.Button
import android.widget.EditText
import com.example.bmi_calculate.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    private lateinit var resultButton: Button
    private lateinit var heightEditText: EditText
    private lateinit var weightEditText: EditText


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        resultButton = binding.resultButton
        heightEditText = binding.heightEditText
        weightEditText = binding.weightEditText

        // 이전에 입력한 값을 읽어오기
        loadData()




        resultButton.setOnClickListener {
            // 마지막에 입력한 내용을 저장
            saveData(heightEditText.text.toString().toInt(),
                weightEditText.text.toString().toInt())
            var intent = Intent(this, ResultActivity::class.java)
            intent.putExtra("weight",weightEditText.text.toString())
            intent.putExtra("height",heightEditText.text.toString())
            startActivity(intent)
        }
    }

    private fun saveData(height: Int, weight: Int) {
        val pref = getSharedPreferences("userData", 0)
        val editor = pref.edit()

        editor.putInt("KEY_HEIGHT", height)
        editor.putInt("KEY_WEIGHT", weight)
        editor.apply()
    }

    private fun loadData() {
        val pref = getSharedPreferences("userData", 0)
        val height = pref.getInt("KEY_HEIGHT", 0)
        val weight = pref.getInt("KEY_WEIGHT", 0)

        if (height != 0 && weight != 0) {
            heightEditText.setText(height.toString())
            weightEditText.setText(weight.toString())
        }
    }
}