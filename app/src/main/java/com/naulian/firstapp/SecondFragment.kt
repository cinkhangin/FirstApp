package com.naulian.firstapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.navigation.NavArgs
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.naulian.firstapp.databinding.FragmentSecondBinding

class SecondFragment : Fragment(R.layout.fragment_second) {

    private val args : SecondFragmentArgs by navArgs()

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

            val listener = object : Listener{
                override fun onClick() {

                }
            }

            btnBack.setOnClickListener {
                listener.onClick()
            }

            val article = args.article
            image.setImageResource(article.image)
            txt.text = article.content

        }
    }
}