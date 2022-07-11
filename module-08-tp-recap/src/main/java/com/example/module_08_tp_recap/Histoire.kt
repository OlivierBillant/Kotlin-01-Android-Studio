package com.example.module_08_tp_recap

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Histoire(val prenom : String, val genre : String, val lieu : String): Parcelable
