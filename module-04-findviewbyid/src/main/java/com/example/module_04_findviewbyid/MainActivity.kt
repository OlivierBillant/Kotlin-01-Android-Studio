package com.example.module_04_findviewbyid

import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val textViewHello = findViewById<TextView>(R.id.textViewHello)
        val editTextCava = findViewById<EditText>(R.id.editTextTextCava)
        val ratingBar = findViewById<RatingBar>(R.id.ratingBar)
        val buttonWifi = findViewById<Button>(R.id.buttonWifi)

        textViewHello.text = "Hello !"
        editTextCava.setText("Comment allez-vous ?")
        ratingBar.rating = 3.5f
        buttonWifi.text = "Maman clique ici pour te connecter"
        buttonWifi.setOnClickListener{
            Toast.makeText(this, R.string.connexion_reussie, Toast.LENGTH_SHORT).show()
            Snackbar.make(it, R.string.connexion_reussie, Snackbar.LENGTH_SHORT).show()
        }
    }
}