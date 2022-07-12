package com.example.module_08_tp_recap

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class HistoireViewModel : ViewModel() {
    var histoire = MutableLiveData<Histoire>()

    init {
        histoire.value = Histoire("Olivier", "Homme", "Grotte")
    }
    fun editPrenom(nouveauPrenom: String):String{
        val oldHistoire = histoire?.value
        oldHistoire?.prenom = nouveauPrenom
        histoire.value= oldHistoire
        return histoire.value?.prenom.toString()
    }
    fun editHistoire(histoire: Histoire){
        this.histoire?.value = histoire
    }
}