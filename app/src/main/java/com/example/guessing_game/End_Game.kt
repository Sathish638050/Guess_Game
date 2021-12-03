package com.example.guessing_game

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import androidx.core.graphics.toColorInt

class End_Game : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_end_game)

        val res = findViewById<TextView>(R.id.result)
        val num = findViewById<TextView>(R.id.randomNum)

        val status = intent.getStringExtra("Status")
        val random = intent.getStringExtra("random")

        if(status == "pass"){
            res.text = "You won! The number is"
            num.setTextColor("#3be607".toColorInt())
            num.text = "$random"
            Toast.makeText(applicationContext,"You won the game",Toast.LENGTH_SHORT).show()
        }else{
            res.text = "You lost after 12 attempts.\nThe number is"
            num.setTextColor("#f20707".toColorInt())
            num.text = "$random"
            Toast.makeText(applicationContext,"You lost the game ", Toast.LENGTH_SHORT).show()
        }
    }
}