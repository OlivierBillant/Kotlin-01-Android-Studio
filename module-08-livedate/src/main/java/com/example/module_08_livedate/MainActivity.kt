package com.example.module_08_livedate

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.module_08_livedate.databinding.ActivityMainBinding

lateinit var binding: ActivityMainBinding
lateinit var vm: CompteurViewModel

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        vm = ViewModelProvider(this).get(CompteurViewModel::class.java)

        vm.compteur.observe(this, { binding.textViewCompteur.text = it?.toString() })

        binding.fabCompteur.setOnClickListener {
            vm.increment()
        }
    }
}
