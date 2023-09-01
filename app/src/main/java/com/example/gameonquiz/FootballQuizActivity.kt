package com.example.gameonquiz

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.os.CountDownTimer
import android.widget.RadioButton
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.gameonquiz.databinding.ActivityFootballQuizBinding
import com.example.gameonquiz.models.FootballConstants.allQuestions
import com.example.gameonquiz.models.FootballConstants.getAllQuestions

class FootballQuizActivity : AppCompatActivity() {

    private lateinit var binding: ActivityFootballQuizBinding
    private lateinit var countdownTimer: CountDownTimer
    private var currentCountdownValue = 10
    private var userScore = 0
    private var questionNumber = 1
    private lateinit var username: String  // Define username as a class-level property

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFootballQuizBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        questionNumber = intent.extras?.getInt("questionNumber", 1) ?: 1
        userScore = intent.extras?.getInt("userscore", 0) ?: 0
        username = intent.getStringExtra("username") ?: "DefaultUsername"

        if (questionNumber == 1) {
            getAllQuestions()
        }

        val listOfQuestions = allQuestions
        val currentQuestion = listOfQuestions[questionNumber - 1]

        binding.tvQuestion.text = currentQuestion.questionText
        binding.rbOptionOne.text = currentQuestion.optionOne
        binding.rbOptionTwo.text = currentQuestion.optionTwo
        binding.rbOptionThree.text = currentQuestion.optionThree
        binding.pbProgress.progress = currentQuestion.id
//      binding.tvProgress.text = "Question $questionNumber of ${listOfQuestions.count()}"
        binding.tvCountdown.text = currentCountdownValue.toString()

        countdownTimer = object : CountDownTimer(10000, 1000) {
            override fun onTick(millisUntilFinished: Long) {
                currentCountdownValue--
                binding.tvCountdown.text = currentCountdownValue.toString()
            }

            override fun onFinish() {
                skipQuestion()
            }
        }
        countdownTimer.start()

        binding.btnNext.setOnClickListener {
            countdownTimer.cancel()

            val selectedAnswer: Int = binding.rgOptions.checkedRadioButtonId

            if (selectedAnswer != -1) {
                val selectedAnswerValue = findViewById<RadioButton>(selectedAnswer)

                if (selectedAnswerValue.text == currentQuestion.correctAnswer) {
                    userScore += 1
                }

                if (questionNumber == listOfQuestions.count()) {
                    val intent = Intent(this, ResultsActivity::class.java)
                    intent.putExtra("userscore", userScore)
                    intent.putExtra("totalQuestions", listOfQuestions.count())
                    intent.putExtra("username",username)
                    intent.putExtra("category", "Football")
                    startActivity(intent)
                    finish()
                } else {
                    questionNumber += 1
                    val intent = Intent(this, FootballQuizActivity::class.java)
                    intent.putExtra("questionNumber", questionNumber)
                    intent.putExtra("userscore", userScore)
                    intent.putExtra("username",username)
                    intent.putExtra("category", "Football")
                    startActivity(intent)
                    finish()
                }
            } else {
                Toast.makeText(this, "Please select your answer", Toast.LENGTH_LONG).show()

                // Handle unanswered question
                if (questionNumber == listOfQuestions.count()) {
                    val intent = Intent(this, ResultsActivity::class.java)
                    intent.putExtra("userscore", userScore)
                    intent.putExtra("totalQuestions", listOfQuestions.count())
                    intent.putExtra("username",username)
                    intent.putExtra("category", "Football")
                    startActivity(intent)
                    finish()
                } else {
                    questionNumber += 1
                    val intent = Intent(this, FootballQuizActivity::class.java)
                    intent.putExtra("questionNumber", questionNumber)
                    intent.putExtra("userscore", userScore)
                    intent.putExtra("username",username)
                    intent.putExtra("category", "Football")
                    startActivity(intent)
                    finish()
                }
            }
        }
    }

    private fun skipQuestion() {
        questionNumber += 1
        val intent = Intent(this, FootballQuizActivity::class.java)
        intent.putExtra("questionNumber", questionNumber)
        intent.putExtra("userscore", userScore)
        intent.putExtra("username",username)
        startActivity(intent)
        finish()
    }
}
