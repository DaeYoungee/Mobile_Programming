package com.example.stopwatch

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import com.example.stopwatch.databinding.ActivityMainBinding
import com.google.android.material.floatingactionbutton.FloatingActionButton
import java.util.*
import kotlin.concurrent.timer

class MainActivity : AppCompatActivity() {

    lateinit var startFab: FloatingActionButton
    private lateinit var secTextView: TextView
    private lateinit var milliTextView: TextView
    private lateinit var lapLayout: LinearLayout
    private lateinit var lapButton: Button
    private lateinit var resetFab: FloatingActionButton
    private var time = 0
    private var timeTask: Timer? = null
    private var isRunning = false
    private var lap = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        startFab = binding.startFab
        secTextView = binding.secTextView
        milliTextView = binding.milisecTextView
        lapLayout = binding.lapLayout
        lapButton = binding.lapButton
        resetFab = binding.resetFab

        startFab.setOnClickListener {
            isRunning = !isRunning

            if (isRunning) {
                start()
            } else {
                pause()
            }
        }

        lapButton.setOnClickListener {
            recordLapTime()
        }
        resetFab.setOnClickListener {
            reset()
        }

    }

    private fun start() {
        startFab.setImageResource(R.drawable.baseline_pause_24)
        timeTask = kotlin.concurrent.timer(period = 10) {
            time++
            val sec = time / 100
            val milli = time % 100
            runOnUiThread {
                secTextView.text = "$sec"
                milliTextView.text = "$milli"
            }
        }
    }

    private fun pause() {
        startFab.setImageResource(R.drawable.baseline_play_arrow_24)
        timeTask?.cancel()
    }

    private fun recordLapTime() {
        val lapTime = this.time
        val textView = TextView(this)
        textView.text = "$lap LAB : ${lapTime / 100} .${lapTime % 100}"
        lapLayout.addView(textView, 0)
        lap++
    }

    private fun reset() {
        timeTask?.cancel()

        time = 0
        isRunning = false
        startFab.setImageResource(R.drawable.baseline_play_arrow_24)
        secTextView.text = "0"
        milliTextView.text = "00"

        lapLayout.removeAllViews()
        lap = 1
    }
}