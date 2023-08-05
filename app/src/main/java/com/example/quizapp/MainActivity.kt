package com.example.quizapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val btn : Button = findViewById(R.id.btn0)
        val ed : EditText = findViewById(R.id.edtext)
        btn.setOnClickListener{
            if(ed.text.isNotEmpty()){
                val intent = Intent(this,QuizQuestion::class.java)
                intent.putExtra(Constants.User_name,ed.text.toString())
                startActivity(intent)
                finish()
            }else{
                Toast.makeText(this, "Please Enter The Name" , Toast.LENGTH_LONG).show()
        }

        }
    }
}