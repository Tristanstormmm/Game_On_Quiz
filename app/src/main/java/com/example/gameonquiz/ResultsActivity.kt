package com.example.gameonquiz

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.gameonquiz.databinding.ActivityResultsBinding

class ResultsActivity : AppCompatActivity() {

    private lateinit var binding: ActivityResultsBinding

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityResultsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val username = intent.getStringExtra("username")
        val userScore = intent.getIntExtra("userscore", 0)
        val totalQuestions = intent.getIntExtra("totalQuestions", 0)
        val category = intent.getStringExtra("category") // Get the quiz category

        binding.tvResultscore.text = userScore.toString()

        if (userScore > totalQuestions / 2) {
            binding.tvResultmessage.text = "Well Done"
        } else {
            binding.tvResultmessage.text = "Try Again"
        }

        val sharedPref = getSharedPreferences("high_scores", Context.MODE_PRIVATE)
        val currentHighScore = sharedPref.getInt(category, 0)
        val highScoreUsername = sharedPref.getString("${category}_username", null)

        if (userScore >= currentHighScore) {
            val editor = sharedPref.edit()
            editor.putInt(category, userScore)
            editor.putString("${category}_username", username)
            editor.apply()

            // Check if the user achieved a new high score and show a Toast
            if (userScore > currentHighScore) {
                Toast.makeText(
                    this,
                    "New high score achieved!",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }

        binding.btnHome.setOnClickListener {
            val intent = Intent(this, CategoryActivity::class.java)
            intent.putExtra("username", username)
            startActivity(intent)
            finish()
        }

        if (category != null) {
            showHighScoreWithUsername(category, highScoreUsername, currentHighScore)
        }
    }

    private fun showHighScoreWithUsername(category: String, username: String?, highScore: Int) {
        "High Score for $category: $highScore, Set by: ${username ?: "Unknown"}"
    }
}

