package com.getini.app

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var statusText: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        statusText = findViewById(R.id.statusText)
        val copyButton = findViewById<Button>(R.id.copyButton)

        copyButton.setOnClickListener {
            val result = IniCopier.copyIni(this)
            statusText.text = result.message
        }
    }
}
