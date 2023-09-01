package com.example.gameonquiz

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.gameonquiz.databinding.ActivityCategoryBinding

class CategoryActivity : AppCompatActivity() {

    private lateinit var binding: ActivityCategoryBinding

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCategoryBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        val username = intent.getStringExtra("username")
        binding.tvWelcome.text = "Welcome, $username!"

        binding.btnOpenSettings.setOnClickListener {
            openSettings(username)
        }

        binding.btnBoxing.setOnClickListener {
            if (username != null) {
                startBoxingQuiz("Boxing", username)
            }
        }

        binding.btnBasketball.setOnClickListener {
            if (username != null) {
                startBasketballQuiz("Basketball", username)
            }
        }

        binding.btnFootball.setOnClickListener {
            if (username != null) {
                startFootballQuiz("Football", username)
            }
        }

        binding.btnRugby.setOnClickListener {
            if (username != null) {
                startRugbyQuiz("Rugby", username)
            }
        }

        binding.btnBoxingHighScore.setOnClickListener {
            val category = "Boxing"
            showHighScore(category)
        }

        binding.btnBasketballHighScore.setOnClickListener {
            val category = "Basketball"
            showHighScore(category)
        }

        binding.btnFootballHighScore.setOnClickListener {
            val category = "Football"
            showHighScore(category)
        }

        binding.btnRugbyHighScore.setOnClickListener {
            val category = "Rugby"
            showHighScore(category)
        }

    }

    private fun openSettings(username: String?) {
        val intent = Intent(this, SettingsActivity::class.java)
        intent.putExtra("username",username)
        startActivity(intent)
    }

    private fun startBoxingQuiz(category: String, username: String) {
        val intent = Intent(this, BoxingQuizActivity::class.java)
        intent.putExtra("username", username)
        intent.putExtra("category", category)
        startActivity(intent)
    }

    private fun startBasketballQuiz(category: String, username: String) {
        val intent = Intent(this, BasketballQuizActivity::class.java)
        intent.putExtra("username", username)
        intent.putExtra("category", category)
        startActivity(intent)
    }

    private fun startFootballQuiz(category: String, username: String) {
        val intent = Intent(this, FootballQuizActivity::class.java)
        intent.putExtra("username", username)
        intent.putExtra("category", category)
        startActivity(intent)
    }

    private fun startRugbyQuiz(category: String, username: String) {
        val intent = Intent(this, RugbyQuizActivity::class.java)
        intent.putExtra("username", username)
        intent.putExtra("category", category)
        startActivity(intent)
    }

    private fun getHighScoreUsernameForCategory(category: String): String {
        val sharedPref = getSharedPreferences("high_scores", Context.MODE_PRIVATE)
        return sharedPref.getString("${category}_username", "") ?: ""
    }

    private fun showHighScore(category: String) {
        val highScore = getHighScoreForCategory(category)
        val highScoreUsername = getHighScoreUsernameForCategory(category)
        Log.d("HighScores", "Category: $category, High Score: $highScore, Username: $highScoreUsername")

        val highScoreMessage = "High Score for $category: $highScore ($highScoreUsername)"
        Toast.makeText(this, highScoreMessage, Toast.LENGTH_SHORT).show()
    }


    private fun getHighScoreForCategory(category: String): Int {

        val sharedPref = getSharedPreferences("high_scores", Context.MODE_PRIVATE)
        return sharedPref.getInt(category, 0)
    }
}

