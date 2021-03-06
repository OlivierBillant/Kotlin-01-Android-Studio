package com.example.module_04_tp_random

import android.content.Context
import android.os.Bundle
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.snackbar.Snackbar
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var buttonGenerate = findViewById<Button>(R.id.buttonGenerate)
        var textViewNumber = findViewById<TextView>(R.id.textViewNumber)
//On aurait aussi pu utiliser lateinit pour initialiser plus tard les variables.
        buttonGenerate.setOnClickListener {
            var editTextBorneInf =
                findViewById<EditText>(R.id.editTextNumberDecimalMin)
            var editTextBorneSup =
                findViewById<EditText>(R.id.editTextNumberDecimalMax)
            var inf = editTextBorneInf.text.toString()
            var sup = editTextBorneSup.text.toString()
            if (inf >= sup) {
                Snackbar.make(it, R.string.erreur_borne, Snackbar.LENGTH_SHORT).show()
            } else {
                var number =
                    Random.nextInt(from = inf.toInt(), until = sup.toInt())
//                Utiliser alternativement le toInt or null qui permet de tester sur null
                textViewNumber.text = number.toString()
                }
            this.currentFocus?.let { view ->
                val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as? InputMethodManager
                imm?.hideSoftInputFromWindow(view.windowToken, 0)
            }
        }
    }
}
