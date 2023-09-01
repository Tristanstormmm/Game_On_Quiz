package com.example.gameonquiz.models

object BasketballConstants {
    var allQuestions = ArrayList<Question>()
    fun getAllQuestions() {

        val que1 = Question(
            1,
            "How many points is a free throw worth?",
            "3",
            "2",
            "1",
            "1"
        )
        val que2 = Question(
            2,
            "What is the highest governing body of basketball?",
            "FIBA",
            "FWBA",
            "FIFA",
            "FIBA"
        )
        val que3 = Question(
            3,
            "When was basketball made?",
            "1891",
            "1723",
            "1903",
            "1891"
        )
        val que4 = Question(
            4,
            "Who made basketball?",
            "James Naismith",
            "Jim Thorpe",
            "William Morgan",
            "James Naismith"
        )
        val que5 = Question(
            5,
            "How many total players are on the basketball at one time.",
            "5",
            "10",
            "15",
            "10"
        )

        allQuestions.add(que1)
        allQuestions.add(que2)
        allQuestions.add(que3)
        allQuestions.add(que4)
        allQuestions.add(que5)
    }
}