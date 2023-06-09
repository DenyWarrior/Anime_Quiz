package com.example.quizapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import java.awt.font.TextAttribute

class EndScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_end_screen)
        val  tvName : TextView = findViewById(R.id.name)
        val  tvscore : TextView = findViewById(R.id.score)
        val  btnFinish : TextView = findViewById(R.id.bttn_finish)

        tvName.text = intent.getStringExtra(Constant.USER_NAME)
        val totalQuestion = intent.getIntExtra(Constant.TOTAL_QUESTIONS,0)
        val correctAnswer = intent.getIntExtra(Constant.CORRECT_ANSWERS,0)

        tvscore.text = "Your Score is $correctAnswer out of $totalQuestion"

        btnFinish.setOnClickListener{
            startActivity(Intent(this,MainActivity::class.java))
        }
    }
}