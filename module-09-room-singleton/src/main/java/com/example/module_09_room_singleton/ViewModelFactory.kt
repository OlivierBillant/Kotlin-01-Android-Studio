package com.example.module_09_room_singleton

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class ViewModelFactory(val application: Application) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
//        Si le viewModel attribué est de ce type, alors on lui attribue la DAO associé
        if (modelClass.isAssignableFrom(PlanteViewModel::class.java)) {
            var planteDao = PlanteDatabase.getInstance(application).planteDao()
            return PlanteViewModel(planteDao, application) as T
        }
        throw IllegalArgumentException("Le view model n'est pas connu")
    }
}