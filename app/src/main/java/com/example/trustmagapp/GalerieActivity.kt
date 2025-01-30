package com.example.trustmagapp

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class GalerieActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_galerie)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val accueilBouton = findViewById<ImageView>(R.id.buttonAccueil)
        val videoBouton = findViewById<ImageView>(R.id.buttonVideo)
        val podcastBouton = findViewById<ImageView>(R.id.buttonPodcast)
        val galerieBouton = findViewById<ImageView>(R.id.buttonGalerie)

        val allButtons = listOf(accueilBouton, videoBouton, podcastBouton, galerieBouton)

        for (button in allButtons) {
            button.setOnClickListener {
                when (button.id) {
                    R.id.buttonAccueil -> {
                        val intentToMainActivity = Intent(this, MainActivity::class.java)
                        startActivity(intentToMainActivity)
                    }
                    R.id.buttonVideo -> {
                        val intentToVideoActivity = Intent(this, VideoActivity::class.java)
                        startActivity(intentToVideoActivity)
                    }
                    R.id.buttonPodcast -> {
                        Toast.makeText(this, "Vous avez appuyé sur le bouton Podcast !", Toast.LENGTH_SHORT).show()
                    }
                    R.id.buttonGalerie -> {
                        val intentToGalerieActivity = Intent(this, GalerieActivity::class.java)
                        startActivity(intentToGalerieActivity)
                    }
                }
            }
        }

    }
}