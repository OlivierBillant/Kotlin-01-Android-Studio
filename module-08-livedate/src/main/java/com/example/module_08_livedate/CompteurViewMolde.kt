package com.example.module_08_livedate

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class CompteurViewModel: ViewModel() {
    var compteur = MutableLiveData<Int>()
    init {
        compteur.value = 0
    }

    fun increment(){
        compteur.value = compteur.value?.inc()
    }
}