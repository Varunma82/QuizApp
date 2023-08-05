package com.example.quizapp

data class Question(
    val id : Int,
    val question : String,
    val image:Int,
    val option : String,
    val option1 : String,
    val option2 : String,
    val option3 : String,
    val cans:Int,
)
