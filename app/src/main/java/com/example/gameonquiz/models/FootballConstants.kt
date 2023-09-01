package com.example.gameonquiz.models

object FootballConstants {
    var allQuestions = ArrayList<Question>()
    fun getAllQuestions() {

        val que1 = Question(
            1,
            "Which team won the 2022/2023 premier league?",
            "Newcastle United",
            "Manchester City",
            "Arsenal",
            "Manchester City"
        )
        val que2 = Question(
            2,
            "How many players in total will be on the field in a typical football match?",
            "22",
            "11",
            "10",
            "22"
        )
        val que3 = Question(
            3,
            "What is the limit of stoppage time that can be added at the end of a game?",
            "10 min",
            "20 min",
            "No limit",
            "No limit"
        )
        val que4 = Question(
            4,
            "Which country won the most FIFA World Cup titles?",
            "Brazil",
            "France",
            "England",
            "Brazil"
        )
        val que5 = Question(
            5,
            "Which football player is nicknamed Zizou?",
            "Zinedine Zidane",
            "Ronaldinho",
            "Steven Gerrard",
            "Zinedine Zidane"
        )

        allQuestions.add(que1)
        allQuestions.add(que2)
        allQuestions.add(que3)
        allQuestions.add(que4)
        allQuestions.add(que5)
    }
}