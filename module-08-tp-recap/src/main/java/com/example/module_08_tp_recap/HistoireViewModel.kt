package com.example.module_08_tp_recap

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class HistoireViewModel : ViewModel() {
    var histoire = MutableLiveData<Histoire>()

    init {
        histoire.value = Histoire("Olivier", "Homme", "Grotte")
    }
    fun editPrenom(nouvelleHistoire: Histoire){
        histoire.value = nouvelleHistoire
    }
}