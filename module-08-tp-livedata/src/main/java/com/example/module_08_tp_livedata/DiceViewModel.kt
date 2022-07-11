package com.example.module_08_tp_livedata

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class DiceViewModel : ViewModel() {

    var dice = MutableLiveData<Int>();

    init {
        dice.value = 0
    }

    fun roll(nbrFaces :Int) : Int  {
        dice.value = (1..nbrFaces).random()
        return dice.value.toString().toInt();
    }
}