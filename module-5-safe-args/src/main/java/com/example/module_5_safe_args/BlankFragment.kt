package com.example.module_5_safe_args

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import com.example.module_5_safe_args.databinding.FragmentBlankBinding


class BlankFragment : Fragment() {
    lateinit var binding: FragmentBlankBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentBlankBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.button.setOnClickListener {
        val user = User(
            binding.editTextPrenom.text.toString(),
            binding.editTextNom.text.toString(),
            binding.editTextNumberAge.text.toString().toInt(),
        )
            var action = BlankFragmentDirections.actionBlankToTarget(user)
                Navigation.findNavController(view)
                    .navigate(action)

        }
    }
}