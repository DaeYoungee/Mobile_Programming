package com.example.project10_2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Gravity
import android.widget.Button
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.RatingBar
import android.widget.TextView
import androidx.core.view.marginTop
import com.example.project10_2.databinding.ActivityMainBinding
import com.example.project10_2.databinding.ActivityResultBinding

class ResultActivity : AppCompatActivity() {
    private lateinit var btnReturn: Button
    private lateinit var layout: LinearLayout
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityResultBinding.inflate(layoutInflater)
        setContentView(binding.root)
        btnReturn = binding.btnReturn
        layout = binding.layout

        title = "투표 결과"

        val voteResult = intent.getIntArrayExtra("VoteCount")
        val imageName = intent.getStringArrayExtra("ImageName")
        val imageField = intent.getIntExtra("ImageField", 0)
        val bestImageName = intent.getStringExtra("BestImageName")
//        binding.resultImage.setImageResource(imageField)
        val imageView = ImageView(this).apply {
            setImageResource(imageField)
        }
        val textView = TextView(this).apply {
            text = bestImageName
            setPadding(0, 16, 0, 16)
            textSize = 20.0f
            gravity = Gravity.CENTER_HORIZONTAL
        }

        layout.addView(textView, 0)
        layout.addView(imageView, 1)
        Log.d("daeYoung", "$imageField")

        val tv = arrayOf<TextView>(
            binding.tv1,
            binding.tv2,
            binding.tv3,
            binding.tv4,
            binding.tv5,
            binding.tv6,
            binding.tv7,
            binding.tv8,
            binding.tv9,
        )
        val rbar = arrayOf<RatingBar>(
            binding.rbar1,
            binding.rbar2,
            binding.rbar3,
            binding.rbar4,
            binding.rbar5,
            binding.rbar6,
            binding.rbar7,
            binding.rbar8,
            binding.rbar9,
        )

        for (i in voteResult!!.indices) {
            tv[i].text = imageName?.get(i) ?: "임시 데이터"
            rbar[i].rating = voteResult[i].toFloat()
        }

        btnReturn.setOnClickListener {
            finish()
        }
    }
}