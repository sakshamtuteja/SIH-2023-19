package com.example.myapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class Upload : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_upload)

        val wordopen = findViewById<Button>(R.id.wordbutton)
        wordopen.setOnClickListener {
            val Intent = Intent(this,Text::class.java)
            startActivity(Intent)
        }
        val imageopen = findViewById<Button>(R.id.imagebtn)
        imageopen.setOnClickListener {
            val Intent = Intent(this,Text::class.java)
            startActivity(Intent)
        }



    }
}