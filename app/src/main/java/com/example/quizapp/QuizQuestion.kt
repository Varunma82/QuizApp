package com.example.quizapp

import android.content.Intent
import android.graphics.Color
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.*
import androidx.core.content.ContextCompat

class QuizQuestion : AppCompatActivity(), View.OnClickListener {
    private var mcurrentposition: Int = 1
    private var mquestionlist: ArrayList<Question>? = null
    private var mselectedoption: Int = 0
    private var mcorrectanswer : Int =  0
    private var musername : String? = null
    private var progressBar: ProgressBar? = null
    private var tvProgressBar: TextView? = null
    private var vQuestion: TextView? = null
    private var img: ImageView? = null
    private var Optionone: TextView? = null
    private var Optiontwo: TextView? = null
    private var Optionthree: TextView? = null
    private var Optionfour: TextView? = null
    private var sbtn : Button? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz_question)
        musername = intent.getStringExtra(Constants.User_name)
        progressBar = findViewById(R.id.progressbar)
        tvProgressBar = findViewById(R.id.tvprogressbar)
        vQuestion = findViewById(R.id.vquestion)
        img = findViewById(R.id.Img)
        Optionone = findViewById(R.id.optionone)
        Optiontwo = findViewById(R.id.optiontwo)
        Optionthree = findViewById(R.id.optionthree)
        Optionfour = findViewById(R.id.optionfour)
          sbtn  = findViewById(R.id.btn1)

        Optionone?.setOnClickListener(this)
        Optiontwo?.setOnClickListener(this)
        Optionthree?.setOnClickListener(this)
        Optionfour?.setOnClickListener(this)
        sbtn?.setOnClickListener(this)



        mquestionlist = Constants.getQuestions()
        setQuestion()

    }



    private fun setQuestion() {
        defaultOptionsView()
        val question: Question = mquestionlist!![mcurrentposition - 1]
        img?.setImageResource(question.image)
        progressBar?.progress = mcurrentposition
        tvProgressBar?.text = "$mcurrentposition / ${progressBar?.max}"
        vQuestion?.text = question.question
        Optionone?.text = question.option
        Optiontwo?.text = question.option1
        Optionthree?.text = question.option2
        Optionfour?.text = question.option3

        if(mcurrentposition == mquestionlist!!.size){
            sbtn?.text = "FINISH"
        }else {
            sbtn?.text = "SUBMIT"
        }
    }
    private fun defaultOptionsView(){
        val options = ArrayList<TextView>()
        Optionone?.let {
            options.add(0,it)
        }
        Optiontwo?.let {
            options.add(1,it)
        }
        Optionthree?.let {
            options.add(2,it)
        }
        Optionfour?.let {
            options.add(3,it)
        }
        for (option in options){
           option.setTextColor(Color.parseColor("#7A8089"))
           option.typeface = Typeface.DEFAULT
            option.background = ContextCompat.getDrawable(
                this,
                R.drawable.default_option_border_bg

            )
        }
    }
    private fun selectedOptionView(tv : TextView, selectedOptionNum : Int){
        defaultOptionsView()
        mselectedoption = selectedOptionNum
        tv.setTextColor(Color.parseColor("#363A43"))
        tv.setTypeface(tv.typeface, Typeface.BOLD)
        tv.background = ContextCompat.getDrawable(
            this,
            R.drawable.selected_border_bg


        )
    }
    override fun onClick(view : View?) {
        when(view?.id){
            R.id.optionone -> {
                Optionone?.let {
                    selectedOptionView(it,1)
                }

        }
            R.id.optiontwo -> {
                Optiontwo?.let {
                    selectedOptionView(it,2)
                }
            }
            R.id.optionthree -> {
                Optionthree?.let {
                    selectedOptionView(it,3)
                }
            }
            R.id.optionfour -> {
                Optionfour?.let {
                    selectedOptionView(it,4)
                }
            }
            R.id.btn1 -> {
                if(mselectedoption == 0){
                    mcurrentposition++

                    when{
                        mcurrentposition <= mquestionlist!!.size ->{
                            setQuestion()
                        }
                        else -> {
                            val intent = Intent(this,winnerpage::class.java)
                            intent.putExtra(Constants.User_name,musername)
                            intent.putExtra(Constants.correct_answer , mcorrectanswer)
                            intent.putExtra(Constants.total_question ,mquestionlist?.size)
                            startActivity(intent)
                            finish()
                        }
                    }

                    }
                else {
                    val question = mquestionlist?.get(mcurrentposition - 1)
                    if(question!!.cans != mselectedoption){
                        answerView(mselectedoption,R.drawable.wrong_option_border_bg)
                    }else{
                        mcorrectanswer++
                    }
                    answerView(question.cans , R.drawable.correct_option_border_bg)
                    if(mcurrentposition == mquestionlist!!.size){
                        sbtn?.text = "Finish"
                    }
                    else {
                        sbtn?.text = "Next Question"
                    }
                    mselectedoption = 0
                    }
                }
            }
    }

    private fun answerView(answer : Int, drawableView : Int){
        when(answer){
            1->{
                Optionone?.background= ContextCompat.getDrawable(this, drawableView)
            }
            2->{
                Optiontwo?.background= ContextCompat.getDrawable(this,drawableView)
            }
            3->{
                Optionthree?.background= ContextCompat.getDrawable(this,drawableView)
            }
            4->{
                Optionfour?.background= ContextCompat.getDrawable(this,drawableView)
            }
        }
    }
}