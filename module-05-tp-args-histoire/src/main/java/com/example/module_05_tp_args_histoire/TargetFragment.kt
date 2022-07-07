package com.example.module_05_tp_args_histoire

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment


class TargetFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_target, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val targetFragmentArgs = arguments?.let { TargetFragmentArgs.fromBundle(it) }
        val textView = view.findViewById<TextView>(R.id.textViewResult)
        textView.text =
            "Il était une fois un être nommé, ${targetFragmentArgs?.histoire?.prenom} " +
                    "qui vivait dans un(e) ${targetFragmentArgs?.histoire?.lieu} " +
                    "..."
    }
}