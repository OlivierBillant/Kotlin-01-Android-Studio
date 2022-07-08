package com.example.module_06_navigation_intent

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        Intent explicite, destination connue
        val buttonMain = findViewById<Button>(R.id.buttonMain)
        buttonMain.setOnClickListener {
            val intentToTarget = Intent(this, TargetActivity::class.java)
            intentToTarget.putExtra("age", 34)
            startActivity(intentToTarget)
            Toast.makeText(
                this,
                intent.getIntExtra("age", -1).toString(),
                Toast.LENGTH_SHORT
            ).show()
        }
//    Intent implicite, destination connue

    }
}