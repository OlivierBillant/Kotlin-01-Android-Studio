package com.example.module_09_room_singleton

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class PlanteViewModel(planteDao: PlanteDao, application: Application) :
    AndroidViewModel(application) {
    lateinit var listePlantes :LiveData<List<Plante>>

    init {
        viewModelScope.launch {
            listePlantes = planteDao.getAll()
        }
    }

}
