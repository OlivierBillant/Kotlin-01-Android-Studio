package com.example.module_09_room_singleton

import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider

class MainActivity : AppCompatActivity() {
    lateinit var vm: PlanteViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        vm = ViewModelProvider(
            this, ViewModelFactory(requireNotNull(application))
        )
            .get(PlanteViewModel::class.java)
        val button = findViewById<Button>(R.id.button)
        button.setOnClickListener {
            vm.listePlantes.observe(this, Observer {
                Toast.makeText(this, it.toString(), Toast.LENGTH_SHORT).show()
            })
        }
//        thread {
////            On déporte les actions en db dans un autre thread
//            PlanteDatabase.getInstance(this).planteDao().insert(
//                Plante(0, "Blette", "Legumeuse", false)
//            )
//
//            PlanteDatabase.getInstance(this).planteDao().insert(
//                Plante(0, "Rhubarbe", "Fruiteuse", true),
//            )
//        var Plante1 = PlanteDatabase.getInstance(this).planteDao().getPlanteById(1)
//        PlanteDatabase.getInstance(this).planteDao().delete(Plante1)
//        }
    }
}