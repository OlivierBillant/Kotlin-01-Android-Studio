package com.example.module_08_tp_viewmodel_de

import androidx.lifecycle.ViewModel

class DiceViewModel : ViewModel() {

    var dice = 0;
//    var nbrFaces = 6;

    fun roll(nbrFaces :Int): Int {
        dice = (1..nbrFaces).random()
        return dice;
    }
}
