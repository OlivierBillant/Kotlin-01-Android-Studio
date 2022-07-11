package com.example.module_08_viewmodel_lifecycle

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.module_08_viewmodel_lifecycle.databinding.ActivityMainBinding

lateinit var binding: ActivityMainBinding
lateinit var vm: CompteurViewModel

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        vm = ViewModelProvider(this).get(CompteurViewModel::class.java)
//        TODO Afficher le compteur
        binding.textViewCompteur.text = vm.compteur.toString()
//        TODO Lorsque le bouton est pressé, incrémenter le compteur depuis le viewModel
        binding.fabCompteur.setOnClickListener {
            vm.increment()
            binding.textViewCompteur.text = vm.compteur.toString()
        }
    }
}