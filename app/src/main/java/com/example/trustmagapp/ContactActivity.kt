package com.example.trustmagapp

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class ContactActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_contact2)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->

            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets



            val textView = findViewById<TextView>(R.id.textView) //sert à rechercher dans l'interface un élément avec l'ID textView.
            val label = " TRUSTMAG "

            //envoie du mail

            val mailEdtext = findViewById<EditText>(R.id.mail)
            val objtEdtext = findViewById<EditText>(R.id.objet)
            val messageEdtext = findViewById<TextView>(R.id.message)
            val buttonMailContact = findViewById<Button>(R.id.buttonMail)

            // Recuperation du text saisie par l'utilisateur

            buttonMailContact.setOnClickListener{

                val mail = mailEdtext.text.toString().trim()
                val objet = objtEdtext.text.toString().trim()
                val msg = messageEdtext.text.toString().trim()

                val mIntent= Intent(Intent.ACTION_SEND)

                mIntent.data = Uri.parse(uristring)
            }













        }
    }
}