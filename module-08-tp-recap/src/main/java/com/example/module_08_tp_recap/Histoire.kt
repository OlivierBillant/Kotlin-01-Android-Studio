package com.example.module_08_tp_recap

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
class Histoire(var prenom : String, var genre : String, var lieu : String): Parcelable
