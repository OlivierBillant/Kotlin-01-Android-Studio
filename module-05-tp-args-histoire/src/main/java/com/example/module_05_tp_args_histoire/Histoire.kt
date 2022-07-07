package com.example.module_05_tp_args_histoire

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Histoire(val prenom: String = "Simon", val lieu: String = "Chateau") :
    Parcelable