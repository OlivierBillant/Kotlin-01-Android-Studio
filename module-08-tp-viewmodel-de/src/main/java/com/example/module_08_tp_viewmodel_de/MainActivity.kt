package com.example.module_08_tp_viewmodel_de

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.module_08_tp_viewmodel_de.databinding.ActivityMainBinding

lateinit var binding: ActivityMainBinding
lateinit var vm: DiceViewModel

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        vm = ViewModelProvider(this).get(DiceViewModel::class.java)
        binding.textViewDice.text = vm.dice.toString()
        binding.fabDice.setOnClickListener {
            vm.roll(binding.editTextNumberFace.text.toString().toInt())
            binding.textViewDice.text = vm.dice.toString()
        }
    }
}