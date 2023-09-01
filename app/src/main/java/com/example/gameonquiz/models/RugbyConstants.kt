package com.example.gameonquiz.models

object RugbyConstants {
    var allQuestions = ArrayList<Question>()
    fun getAllQuestions() {

        val que1 = Question(
            1,
            "How many Rugby World Cups have South Africa won?",
            "4",
            "2",
            "3",
            "3"
        )
        val que2 = Question(
            2,
            "Which international team are known as The Pumas?",
            "Argentina",
            "France",
            "Australia",
            "Argentina"
        )
        val que3 = Question(
            3,
            "Who is credited with inventing Rugby Union?",
            "Mark Rugby",
            "William Webb Ellis",
            "Eddie Jones",
            "William Webb Ellis"
        )
        val que4 = Question(
            4,
            "Which team has the highest win record?",
            "New Zealand",
            "South Africa",
            "Ireland",
            "New Zealand"
        )
        val que5 = Question(
            5,
            "What is the nickname for the Japanese rugby team?",
            "The Red Warriors",
            "The Polka Dots",
            "The Cherry Blossoms",
            "The Cherry Blossoms"
        )

        allQuestions.add(que1)
        allQuestions.add(que2)
        allQuestions.add(que3)
        allQuestions.add(que4)
        allQuestions.add(que5)

    }
}