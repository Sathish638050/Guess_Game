package com.example.guessing_game

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import com.google.android.material.textfield.TextInputLayout

class MainActivity : AppCompatActivity() {

    val random = (0..1000).random();
    var attempt = 12

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val enterNum = findViewById<TextInputLayout>(R.id.enterValue)
        val btn = findViewById<Button>(R.id.clickBtn)
        val command = findViewById<TextView>(R.id.displayCommand)

        btn.setOnClickListener {
            val value = enterNum.editText?.text?.toString()
            if(value.isNullOrBlank()){
                command.text = "Please enter number"
            }else{
                if(attempt > 1){
                    if(value.toInt() > random){
                        command.text = "No :) My number is smaller "
                        attempt --
                        Toast.makeText(applicationContext,"Balance only $attempt attempts",Toast.LENGTH_SHORT).show()
                    }else if (value.toInt() < random){
                        command.text = "No :) My number is bigger"
                        attempt --
                        Toast.makeText(applicationContext,"Balance only $attempt attempts",Toast.LENGTH_SHORT).show()
                    }else{
                        startActivity(Intent(this,End_Game::class.java)
                            .putExtra("Status","pass")
                            .putExtra("random",random.toString()))

                    }
                }else{
                    startActivity(Intent(this,End_Game::class.java)
                        .putExtra("Sttus","Fail")
                        .putExtra("random",random.toString()))

                }
            }
        }
    }
}