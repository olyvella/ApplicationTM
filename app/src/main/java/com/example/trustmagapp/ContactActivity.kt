package com.example.trustmagapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.widget.Toast


class ContactActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_contact2)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            return@setOnApplyWindowInsetsListener insets
        }

        //
            val mailEdtext = findViewById<EditText>(R.id.mail)
            val objtEdtext = findViewById<EditText>(R.id.objet)
            val messageEdtext = findViewById<EditText>(R.id.message)
            val buttonMailContact = findViewById<Button>(R.id.buttonMail)

            // Recuperation du text saisie par l'utilisateur

            buttonMailContact.setOnClickListener {
                val mail = mailEdtext.text.toString().trim()
                val objet = objtEdtext.text.toString().trim()
                val msg = messageEdtext.text.toString().trim()

            // Verifié si l'utilisateur a bien saisie tout les champs

                if (mail.isNotEmpty() && objet.isNotEmpty() && msg.isNotEmpty()) {
                    val mIntent = Intent(Intent.ACTION_SEND).apply {
                        type = "message/rfc822" // Limite aux applications d'email
                        putExtra(Intent.EXTRA_EMAIL, arrayOf("rejoindre@trustmag.fr"))
                        putExtra(Intent.EXTRA_SUBJECT, objet)
                        putExtra(Intent.EXTRA_TEXT, msg)
                    }

                    try {
                        startActivity(Intent.createChooser(mIntent, "Choisir une application de messagerie"))
                    } catch (e: Exception) {
                        Toast.makeText(this, "Aucune application de messagerie trouvée", Toast.LENGTH_SHORT).show()
                    }
                } else {
                    Toast.makeText(this, "Veuillez remplir tous les champs", Toast.LENGTH_SHORT).show()
                }
            }

            val fleche = findViewById<ImageButton>(R.id.icArrow2)

            fleche.setOnClickListener{
                Toast.makeText(this, "Flèche de retour !", Toast.LENGTH_SHORT).show()
            }
        }
    }














