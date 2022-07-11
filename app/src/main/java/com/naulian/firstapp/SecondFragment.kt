package com.naulian.firstapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import android.widget.Toast
import androidx.navigation.fragment.findNavController
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

            txt.text = when(Singleton.currentPage){
                0 -> "Page 0"
                1 -> "Page 1"
                2 -> "Page 2"
                3 -> "Page 3"
                4 -> "Page 4"
                5 -> "Page 5"
                else -> "Page Not Found"
            }

        }
    }
}