package com.example.calculadoramaxkotlin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        val atras = findViewById<Button>(R.id.buttonBack)
        val siguiente = findViewById<Button>(R.id.buttonNext)

        atras.setOnClickListener {
            finish()
        }
        siguiente.setOnClickListener {
            val intent = Intent(this, MainActivity3::class.java)
            startActivity(intent)
        }
    }
}