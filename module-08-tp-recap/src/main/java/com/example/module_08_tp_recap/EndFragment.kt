package com.example.module_08_tp_recap

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
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

        vm.histoire.observe(viewLifecycleOwner) { vm.histoire.value?.prenom = binding.editTextPrenomEnd.text.toString() }  /*{ binding.viewModel = vm } */
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val targetFragmentArgs = arguments?.let { EndFragmentArgs.fromBundle(it) }
        val textView = view.findViewById<TextView>(R.id.textView)
       vm.histoire.value?.prenom = targetFragmentArgs?.histoire?.prenom.toString()
        textView.text =
            "Il était une fois un être nommé, ${vm.histoire.value?.prenom} " +
                    "qui était un ${targetFragmentArgs?.histoire?.genre} et " +
                    " vivait dans un(e) ${targetFragmentArgs?.histoire?.lieu} " +
                    "..."

        val buttonEnd = view.findViewById<Button>(R.id.buttonEnd)
        buttonEnd.setOnClickListener {
            vm.editPrenom(
                Histoire(binding.buttonEnd.text.toString(),
                targetFragmentArgs?.histoire?.genre.toString(),
                targetFragmentArgs?.histoire?.lieu.toString()
                ))
        }
    }
    /*  val buttonEnd = view.findViewById<Button>(R.id.buttonEnd)
      buttonEnd.setOnClickListener {
          val intentToTarget = Intent(this, TargetActivity::class.java)
          intentToTarget.putExtra("prenom", binding.editTextPrenomEnd.text)
          intentToTarget.putExtra("genre", targetFragmentArgs?.histoire?.genre)
          intentToTarget.putExtra("prenom", targetFragmentArgs?.histoire?.prenom)
          startActivity(intentToTarget)
          Toast.makeText(
              this,
              intent.getIntExtra("prenom", -1).toString(),
              Toast.LENGTH_SHORT
          ).show()
  }*/
}
