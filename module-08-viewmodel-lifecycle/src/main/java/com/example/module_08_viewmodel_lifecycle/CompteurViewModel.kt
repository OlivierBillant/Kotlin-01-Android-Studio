package com.example.module_08_viewmodel_lifecycle

import androidx.lifecycle.ViewModel

class CompteurViewModel : ViewModel() {

    var compteur = 0;

    // = return, ++compteur increment puis envoi la val augmentée
    fun increment() = ++compteur
}