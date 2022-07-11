package com.example.module_08_tp_livedata

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.module_08_tp_livedata.databinding.ActivityMainBinding


lateinit var binding: ActivityMainBinding
lateinit var vm: DiceViewModel

class MainActivity : AppCompatActivity(), View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        vm = ViewModelProvider(this).get(DiceViewModel::class.java)

        vm.dice.observe(this) { binding.textViewDice.text = it?.toString() }

//        binding.button2.setOnClickListener {
//            vm.roll(binding.button2.text.toString().toInt())
//        }
//        binding.button10.setOnClickListener {
//            vm.roll(binding.button10.text.toString().toInt())
//        }
//        binding.button20.setOnClickListener {
//            vm.roll(binding.button20.text.toString().toInt())
//        }
//        binding.button6.setOnClickListener {
//            vm.roll(binding.button6.text.toString().toInt())
//        }
//        binding.button12.setOnClickListener {
//            vm.roll(binding.button12.text.toString().toInt())
//        }
//        binding.button24.setOnClickListener {
//            vm.roll(binding.button24.text.toString().toInt())
//        }

     binding.button2.setOnClickListener(this)
     binding.button10.setOnClickListener(this)
     binding.button20.setOnClickListener(this)
     binding.button6.setOnClickListener(this)
     binding.button12.setOnClickListener(this)
     binding.button24.setOnClickListener(this)
    }

    override fun onClick(p0: View?) {

        vm.roll(
            when (p0?.getId()) {
                R.id.button2
                -> 2
                R.id.button10
                -> 10
                R.id.button20
                -> 20
                R.id.button6
                -> 6
                R.id.button12
                -> 12
                R.id.button24
                -> 24
                else -> return
            }
        )
    }
}