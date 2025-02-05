package com.example.trustmagapp

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class VideoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        enableEdgeToEdge()
        setContentView(R.layout.activity_video)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val accueilBouton = findViewById<ImageView>(R.id.buttonAccueil)
        val videoBouton = findViewById<ImageView>(R.id.buttonVideo)
        val podcastBouton = findViewById<ImageView>(R.id.buttonPodcast)
        val galerieBouton = findViewById<ImageView>(R.id.buttonGalerie)
        val menuBouton = findViewById<ImageView>(R.id.buttonMenu)

        val allButtons = listOf(accueilBouton, videoBouton, podcastBouton, galerieBouton, menuBouton)

        for (button in allButtons) {
            button.setOnClickListener {
                when (button.id) {
                    R.id.buttonAccueil -> {
                        Intent(this, MainActivity::class.java).also {
                            startActivity(it)
                        }
                    }
                    R.id.buttonVideo -> {
                        Intent(this, VideoActivity::class.java).also {
                            startActivity(it)
                        }
                    }
                    R.id.buttonPodcast -> {
                        Toast.makeText(this, "Vous avez appuyé sur le bouton Podcast !", Toast.LENGTH_SHORT).show()
                    }
                    R.id.buttonGalerie -> {
                        Intent(this, GalerieActivity::class.java).also {
                            startActivity(it)
                        }
                    }
                    R.id.buttonMenu -> {
                        Intent(this, MenuActivity::class.java).also {
                            startActivity(it)
                        }
                    }
                }
            }
        }

    }
}