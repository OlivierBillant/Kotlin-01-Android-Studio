package com.example.module_08_tp_recap

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment


class EndFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_end, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val targetFragmentArgs = arguments?.let { EndFragmentArgs.fromBundle(it) }
        val textView = view.findViewById<TextView>(R.id.textView)
        textView.text =
            "Il était une fois un être nommé, ${targetFragmentArgs?.histoire?.prenom} " +
                    "qui était un ${targetFragmentArgs?.histoire?.genre} et "+
                    " vivait dans un(e) ${targetFragmentArgs?.histoire?.lieu} " +
                    "..."
    }
}