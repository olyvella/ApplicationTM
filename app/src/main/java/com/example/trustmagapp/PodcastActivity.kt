package com.example.trustmagapp

import android.content.Intent
import android.os.Bundle
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.ImageView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class PodcastActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContentView(R.layout.activity_podcast)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

//        val webView: WebView = findViewById(R.id.webView)
//        webView.settings.javaScriptEnabled = true
//        webView.loadUrl("https://open.spotify.com/show/TON_PODCAST_ID")
//
//        webView.settings.apply {
//            javaScriptEnabled = true
//            domStorageEnabled = true
//            loadWithOverviewMode = true
//            useWideViewPort = true // Active le viewport large
//            builtInZoomControls = true
//            displayZoomControls = false
//        }
//
//        // Empêche l'ouverture des liens externes dans un navigateur
//        webView.webViewClient = WebViewClient()
//
//        // Charger l'URL du podcast Spotify
//        webView.loadUrl("https://open.spotify.com/show/TON_PODCAST_ID")

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



