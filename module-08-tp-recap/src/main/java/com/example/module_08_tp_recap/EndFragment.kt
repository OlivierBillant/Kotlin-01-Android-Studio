package com.example.module_08_tp_recap

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.module_08_tp_recap.databinding.FragmentEndBinding


class EndFragment : Fragment() {
    lateinit var binding: FragmentEndBinding
    lateinit var vm: HistoireViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentEndBinding.inflate(inflater, container, false)
        vm = ViewModelProvider(this).get(HistoireViewModel::class.java)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        vm.histoire.observe(viewLifecycleOwner) {
            binding.histoire = it
        }
        val targetFragmentArgs = arguments?.let { EndFragmentArgs.fromBundle(it) }
        targetFragmentArgs?.histoire?.let { vm.editHistoire(it) }

        val buttonEnd = view.findViewById<Button>(R.id.buttonEnd)
        buttonEnd.setOnClickListener {
            vm.editPrenom(
                binding.editTextPrenomEnd.text.toString()
            )
        }
    }
}
