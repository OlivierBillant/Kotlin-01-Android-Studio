package com.example.module_04_databinding

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.module_04_databinding.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
//    On crée une variable activityMainBinding
    lateinit var amb: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        On initialise la vue
        amb = DataBindingUtil.setContentView(this, R.layout.activity_main)
        amb.u = Utilisateur("143 rue JJ", 34, "Olivier", "Billant")
    }
}