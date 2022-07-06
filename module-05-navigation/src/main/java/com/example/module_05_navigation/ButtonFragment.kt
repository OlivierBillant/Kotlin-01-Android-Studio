package com.example.module_05_navigation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation


class ButtonFragment : Fragment() {
    //equivalent au set contain view dans l'activité
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_button, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val button = view.findViewById<Button>(R.id.buttonToTarget)
//        premiere methode pour lier un boutton a sa cible
//        on overide le setOnClick.
//        Fonctionnera pour tous les éléments
        button.setOnClickListener {
            Navigation.findNavController(view)
                .navigate(R.id.action_buttonFragment_to_targetFragment)
        }
//        deuxième methode pour lier un  bouton à sa cible
//        On affecte simplement le on clique listener.
//        Bouton only
//        button.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.action_buttonFragment_to_targetFragment))
    }
}