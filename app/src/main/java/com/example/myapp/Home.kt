package com.example.myapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class Home : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

       var button4 = findViewById<Button>(R.id.button4)
        button4.setOnClickListener {
            val intent = Intent(this, History::class.java)
            startActivity(intent)
        }

            var button3 = findViewById<Button>(R.id.button3)
            button3.setOnClickListener {
                val intent = Intent(this, Voice::class.java)
                startActivity(intent)
            }

                var button = findViewById<Button>(R.id.button)
                button.setOnClickListener {
                    val intent = Intent(this, Scan::class.java)
                    startActivity(intent)
                }

        var button2 = findViewById<Button>(R.id.button2)
        button2.setOnClickListener {
            val intent = Intent(this,Upload::class.java)
            startActivity(intent)
            }
        }}


