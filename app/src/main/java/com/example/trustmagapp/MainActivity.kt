package com.example.trustmagapp

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.ImageView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

@SuppressLint("WrongViewCast")
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        enableEdgeToEdge()
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
                        Toast.makeText(this, "Vous avez appuyé sur le bouton Accueil !", Toast.LENGTH_SHORT).show()
                    }
                    R.id.buttonVideo -> {
                        Toast.makeText(this, "Vous avez appuyé sur le bouton Video !", Toast.LENGTH_SHORT).show()
                    }
                    R.id.buttonPodcast -> {
                        Toast.makeText(this, "Vous avez appuyé sur le bouton Podcast !", Toast.LENGTH_SHORT).show()
                    }
                    R.id.buttonGalerie -> {
                        Toast.makeText(this, "Vous avez appuyé sur le bouton Galerie !", Toast.LENGTH_SHORT).show()
                    }
                }
            }
        }

    }
}