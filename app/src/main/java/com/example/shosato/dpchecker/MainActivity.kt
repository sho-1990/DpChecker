package com.example.shosato.dpchecker

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.DisplayMetrics
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val displayMetrics: DisplayMetrics = resources.displayMetrics
        val contentText: TextView = findViewById(R.id.dpContent) as TextView
        contentText.text = displayMetrics.densityDpi.toString()
    }
}
