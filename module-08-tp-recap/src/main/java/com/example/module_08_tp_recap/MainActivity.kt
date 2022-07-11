package com.example.module_08_tp_recap

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (R.id.buttonEnd != null) {
            val buttonEnd = findViewById<Button>(R.id.buttonEnd)
            buttonEnd.setOnClickListener {
                val intentToTarget = Intent(this, TargetActivity::class.java)
                intentToTarget.putExtra("prenom", 34)
                startActivity(intentToTarget)
                Toast.makeText(
                    this,
                    intent.getIntExtra("prenom", -1).toString(),
                    Toast.LENGTH_SHORT
                ).show()
            }
        }
    }
}