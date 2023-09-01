package com.example.gameonquiz

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.gameonquiz.databinding.ActivitySettingsBinding

class SettingsActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySettingsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_settings)
        binding = ActivitySettingsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val btnOpenYoutube: Button = findViewById(R.id.btnOpenYoutube)
        val btnResetHighScores: Button = findViewById(R.id.btnResetHighScores)
        val username = intent.getStringExtra("username")

        btnOpenYoutube.setOnClickListener {
            openGitHub()
        }

        btnResetHighScores.setOnClickListener {
            resetHighScores()
            Toast.makeText(this, "High scores reset.", Toast.LENGTH_SHORT).show()
        }

        binding.btnOpenHome.setOnClickListener {
            val intent = Intent(this, CategoryActivity::class.java)
            intent.putExtra("username", username)
            startActivity(intent)
            finish()
        }
    }

    private fun openGitHub() {
        val githubUrl = "https://github.com/Tristanstormmm/Game_On_Quiz"
        val intent = Intent(Intent.ACTION_VIEW, Uri.parse(githubUrl))
        startActivity(intent)
    }

    private fun resetHighScores() {
        val sharedPref = getSharedPreferences("high_scores", Context.MODE_PRIVATE)
        val editor = sharedPref.edit()
        editor.clear()
        editor.apply()

    }
}