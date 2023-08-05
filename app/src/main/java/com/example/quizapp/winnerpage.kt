 package com.example.quizapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

 class winnerpage : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_winnerpage)
        val tvname : TextView = findViewById(R.id.t2)
        val tvscore : TextView = findViewById(R.id.t3)
        val fbtn : Button = findViewById(R.id.button)

        tvname.text = intent.getStringExtra(Constants.User_name)
      val totalq = intent.getIntExtra(Constants.total_question,0)
        val canswer = intent.getIntExtra(Constants.correct_answer,0)
        tvscore.text = "Your Score is $canswer out of $totalq"
        fbtn.setOnClickListener{
            startActivity(Intent(this,MainActivity::class.java))
        }

    }
}