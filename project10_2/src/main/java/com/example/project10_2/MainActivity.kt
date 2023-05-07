package com.example.project10_2

import android.app.Activity
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Button

class MainActivity : Activity() {
    public override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        title = "��Ƽ��Ƽ �׽�Ʈ ����"
        android.util.Log.i("��Ƽ��Ƽ �׽�Ʈ", "onCreate()")

        var btnDial = findViewById<Button>(R.id.btnDial)
        btnDial.setOnClickListener {
            var uri = Uri.parse("tel:010-1234-5678")
            var intent = Intent(Intent.ACTION_DIAL, uri)
            startActivity(intent)
        }

        var btnFinish = findViewById<Button>(R.id.btnFinish)
        btnFinish.setOnClickListener {
            finish()
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        android.util.Log.i("daeYoung", "onDestroy()")
    }

    override fun onPause() {
        super.onPause()
        android.util.Log.i("daeYoung", "onPause()")
    }

    override fun onRestart() {
        super.onRestart()
        android.util.Log.i("daeYoung", "onRestart()")
    }

    override fun onResume() {
        super.onResume()
        android.util.Log.i("daeYoung", "onResume()")
    }

    override fun onStart() {
        super.onStart()
        android.util.Log.i("daeYoung", "onStart()")
    }

    override fun onStop() {
        super.onStop()
        android.util.Log.i("daeYoung", "onStop()")
    }



}
