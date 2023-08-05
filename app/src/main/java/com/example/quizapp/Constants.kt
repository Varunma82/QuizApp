package com.example.quizapp

object Constants {
    const val User_name :String = "user name"
    const val total_question : String = "total_question"
    const val correct_answer : String = "correct_answer"

    fun getQuestions():ArrayList<Question>{
        val questionList = ArrayList<Question>()
        val que1 = Question(
            1 , "What country does this flag belong to ?",
             R.drawable.america,
            "Australia",
            "Argentina",
            "Austria",
            "America",
            4
        )
       questionList.add(que1)
        val que2 = Question(
            2 , "Choose the correct option.",
            R.drawable.ss,
            "97",
            "57",
            "67",
            "46",
            3
        )
        questionList.add(que2)
         val que3 = Question(
             3 , "What country does this flag belong to ?",
            R.drawable.russia,
            "United Kingdom",
            "Argentina",
            "Russia",
            "Afganistan",
            3
        )
        questionList.add(que3)
        val que4 = Question(
            4 , "What country does this flag belong to ?",
            R.drawable.oman,
            "United Kingdom",
            "Oman",
            "Belar",
            "Poland",
            2
        )
        questionList.add(que4)
        val que5 = Question(
            5, "What country does this flag belong to ?",
            R.drawable.japan,
            "Japan",
            "Laos",
            "Libya",
            "Niger",
            1
        )
        questionList.add(que5)
        val que6 = Question(
            6 , "What country does this flag belong to ?",
            R.drawable.denmark,
            "Algeria",
            "Spain",
            "Iceland",
            "Denmark",
            4
        )
        questionList.add(que6)
        val que7 = Question(
            7 , "What country does this flag belong to ?",
            R.drawable.bhutan,
            "Taiwan",
            "Bhutan",
            "Vietnam",
            "Iraq",
            2
        )
        questionList.add(que7)
        val que8 = Question(
            8 , "What country does this flag belong to ?",
            R.drawable.austria,
            "Libya",
            "Finland",
            "France",
            "Austria",
            4
        )
        questionList.add(que8)
        val que9 = Question(
            9 , "What country does this flag belong to ?",
            R.drawable.australia,
            "Australia",
            "Austria",
            "America",
            "Yemen",
            1
        )
        questionList.add(que9)
        val que10 = Question(
            10 , "What country does this flag belong to ?",
            R.drawable.argentina,
            "Germany",
            "Mali",
            "Argentina",
            "Poland",
            3
        )
        questionList.add(que10)
        return questionList
    }

}