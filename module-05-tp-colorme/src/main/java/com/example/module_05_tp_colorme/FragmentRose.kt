package com.example.module_05_tp_colorme

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation

class FragmentRose : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_rose, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val button = view.findViewById<Button>(R.id.buttonRose)

        button.setOnClickListener {
            if ((1..2).random() == 1) {
                Navigation.findNavController(view)
                    .navigate(R.id.action_fragmentRose_to_fragmentJaune)
            } else {
                Navigation.findNavController(view)
                    .navigate(R.id.action_fragmentRose_to_fragmentVert)
            }
        }
    }
}