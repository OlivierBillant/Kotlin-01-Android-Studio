package com.example.module_07_lifecycle

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity() {
    lateinit var fab: FloatingActionButton
    lateinit var textViewCompteur: TextView
    var compteur = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        fab = findViewById(R.id.fab)
        textViewCompteur = findViewById(R.id.textViewCompteur)
        textViewCompteur.text = compteur.toString()

        fab.setOnClickListener {
            compteur++
            textViewCompteur.text = compteur.toString()
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState?.putInt("compteur", compteur)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        compteur = savedInstanceState.getInt("compteur")
        textViewCompteur.text = compteur.toString()
    }

}