package com.naulian.firstapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.naulian.firstapp.databinding.FragmentFirstBinding
import com.naulian.firstapp.databinding.FragmentSecondBinding

class SecondFragment : Fragment(R.layout.fragment_second) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val viewBinding =FragmentSecondBinding.bind(view)

        viewBinding.apply {
            toolBar.setNavigationOnClickListener {
                findNavController().popBackStack()
            }

            toolBar.setOnMenuItemClickListener {
                when(it.itemId){
                    R.id.action_finish -> {
                        requireActivity().finish()
                        true
                    }
                    R.id.action_one -> {
                        Toast.makeText(requireContext(), "one", Toast.LENGTH_SHORT).show()
                        true
                    }
                    R.id.action_two -> {
                        Toast.makeText(requireContext(), "two", Toast.LENGTH_SHORT).show()
                        true
                    }

                    R.id.action_icon ->{
                        Toast.makeText(requireContext(), "icon", Toast.LENGTH_SHORT).show()
                        true
                    }

                    else -> false
                }
            }


            btnBack.setOnClickListener {
                findNavController().popBackStack()
            }
        }
    }
}