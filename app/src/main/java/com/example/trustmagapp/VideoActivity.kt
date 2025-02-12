package com.example.trustmagapp

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.Button
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

        // Appliquer les marges système
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(android.R.id.content)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Récupérer les boutons
        val accueilBouton = findViewById<ImageView>(R.id.buttonAccueil)
        val videoBouton = findViewById<ImageView>(R.id.buttonVideo)
        val podcastBouton = findViewById<ImageView>(R.id.buttonPodcast)
        val galerieBouton = findViewById<ImageView>(R.id.buttonGalerie)
        val menuBouton = findViewById<ImageView>(R.id.buttonMenu)

        val allButtons = listOf(accueilBouton, videoBouton, podcastBouton, galerieBouton, menuBouton)

        // Gestion des clics
        for (button in allButtons) {
            button.setOnClickListener { view ->
                when (view.id) {
                    R.id.buttonAccueil -> startActivity(Intent(this, MainActivity::class.java))
                    R.id.buttonVideo -> startActivity(Intent(this, VideoActivity::class.java))
                    R.id.buttonPodcast -> Toast.makeText(this, "Vous avez appuyé sur le bouton Podcast !", Toast.LENGTH_SHORT).show()
                    R.id.buttonGalerie -> startActivity(Intent(this, GalerieActivity::class.java))
                    R.id.buttonMenu -> startActivity(Intent(this, MenuActivity::class.java))
                }
            }
        }

        // Gestion du bouton YouTube (rediriger vers la chaîne YouTube)
        val youtubeButton = findViewById<Button>(R.id.button5)
        youtubeButton.setOnClickListener {
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/@trustmagtv2264"))
            startActivity(intent)
        }


        // Configurer WebView
        val webView = findViewById<WebView>(R.id.webview)
        val webSettings = webView.settings
        webSettings.javaScriptEnabled = true
        webSettings.mediaPlaybackRequiresUserGesture = false
        webSettings.domStorageEnabled = true
        webSettings.useWideViewPort = true
        webSettings.loadWithOverviewMode = true

        webView.webViewClient = object : WebViewClient() {
            override fun shouldOverrideUrlLoading(view: WebView?, url: String?): Boolean {
                view?.loadUrl(url ?: "")
                return true
            }
        }
        // Charger la vidéo YouTube
        webView.loadUrl("https://www.youtube.com/embed/GloFTN8JYDI?si=JVBunN4aLpPBLLja")
    }
}
