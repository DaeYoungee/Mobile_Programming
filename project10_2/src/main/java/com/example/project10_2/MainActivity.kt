package com.example.project10_2

import android.app.Activity
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import com.example.project10_2.databinding.ActivityMainBinding

class MainActivity : Activity() {
    lateinit var btnResult: Button
    public override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        btnResult = binding.btnResult

        title = "명화 선호도 투표"

        val voteCount = IntArray(9)
        repeat(8) { voteCount[it] = 0 }
        var maxVoteCount = voteCount[0]
        var maxImageField: Int? = null
        var maxImageName: String? = null

        val image = arrayOf<ImageView>(
            binding.iv1,
            binding.iv2,
            binding.iv3,
            binding.iv4,
            binding.iv5,
            binding.iv6,
            binding.iv7,
            binding.iv8,
            binding.iv9
        )

        val imgName = arrayOf(
            "독서하는 소녀",
            "꽃장식 모자 소녀",
            "부채를 든 소녀",
            "이레느깡 단 베르양",
            "잠자는 소녀",
            "테라스의 두 자매",
            "피아노 레슨",
            "피아노 앞의 소녀들",
            "해변에서"
        )

        val imageField = arrayOf(
            R.drawable.pic1,
            R.drawable.pic2,
            R.drawable.pic3,
            R.drawable.pic4,
            R.drawable.pic5,
            R.drawable.pic6,
            R.drawable.pic7,
            R.drawable.pic8,
            R.drawable.pic9
        )

        for (i in image.indices) {
            image[i].setOnClickListener {
                voteCount[i]++
                Toast.makeText(
                    applicationContext,
                    "${imgName[i]} : 총 ${voteCount[i]}  표",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }

        btnResult.setOnClickListener {
            for (i in voteCount.indices) {
                if (maxVoteCount < voteCount[i]) {
                    maxVoteCount = voteCount[i]
                    maxImageField = imageField[i]
                    maxImageName = imgName[i]
                }
            }
            val intent = Intent(applicationContext, ResultActivity::class.java).also {
                it.putExtra("VoteCount", voteCount)
                it.putExtra("ImageName", imgName)
                it.putExtra("ImageField", maxImageField)
                it.putExtra("BestImageName", maxImageName)
            }
            startActivity(intent)
        }



    }


}



