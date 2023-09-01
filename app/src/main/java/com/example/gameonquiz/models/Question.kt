package com.example.gameonquiz.models

data class Question(
    val id: Int,
    val questionText: String,
    val optionOne: String,
    val optionTwo: String,
    val optionThree: String?,
    val correctAnswer: String
)
