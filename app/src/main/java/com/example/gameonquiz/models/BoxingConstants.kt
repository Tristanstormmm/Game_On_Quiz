package com.example.gameonquiz.models

object BoxingConstants {
    var allQuestions = ArrayList<Question>()
    fun getAllQuestions() {

        val que1 = Question(
            1,
            "How many rounds are there in a professional boxing match?",
            "8",
            "5",
            "12",
            "12"
        )
        val que2 = Question(
            2,
            "What is the nickname of Tyson Fury?",
            "Hammer Fists",
            "Furious",
            "The Gypsy King",
            "The Gypsy King"
        )
        val que3 = Question(
            3,
            "Which part of Evander Holyfield did Mike Tyson bite?",
            "Ear",
            "Neck",
            "Shoulder",
            "Ear"
        )
        val que4 = Question(
            4,
            "What item is thrown into the boxing ring as a token of defeat?",
            "Water",
            "A towel or sponge",
            "White Cloth",
            "A towel or sponge"
        )
        val que5 = Question(
            5,
            "In which state is the iconic boxing venue Madison Square Garden?",
            "Washington",
            "Las Vegas",
            "New York",
            "New York"
        )

        allQuestions.add(que1)
        allQuestions.add(que2)
        allQuestions.add(que3)
        allQuestions.add(que4)
        allQuestions.add(que5)
    }
}