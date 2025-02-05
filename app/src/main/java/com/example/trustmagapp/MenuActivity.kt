package com.example.trustmagapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MenuActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_menu)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val retourAccueil = findViewById<Button>(R.id.button)
        val retourVideo = findViewById<Button>(R.id.button2)
        val retourPodcast = findViewById<Button>(R.id.button3)
        val retourGalerie = findViewById<Button>(R.id.button4)
        val contactBouton = findViewById<Button>(R.id.buttonContact)

        val allButtons = listOf(retourAccueil, retourVideo, retourPodcast, retourGalerie, contactBouton)

        for (button in allButtons) {
            button.setOnClickListener {
                when (button.id) {
                    R.id.button -> {
                        Intent(this, MainActivity::class.java).also {
                            startActivity(it)
                        }
                    }
                    R.id.button2 -> {
                        Intent(this, VideoActivity::class.java).also {
                            startActivity(it)
                        }
                    }
                    R.id.button3 -> {
                        Toast.makeText(this, "Vous avez appuyé sur le bouton Podcast !", Toast.LENGTH_SHORT).show()
                    }
                    R.id.button4 -> {
                        Intent(this, GalerieActivity::class.java).also {
                            startActivity(it)
                        }
                    }
                    R.id.buttonContact -> {
                        Intent(this, ContactActivity::class.java).also {
                            startActivity(it)
                        }
                    }
                }
            }
        }

        val fleche = findViewById<ImageButton>(R.id.icArrow)

        fleche.setOnClickListener{
            Toast.makeText(this, "Flèche de retour !", Toast.LENGTH_SHORT).show()
        }

    }
}