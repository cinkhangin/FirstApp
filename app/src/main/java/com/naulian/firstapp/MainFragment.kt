package com.naulian.firstapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.ListAdapter
import androidx.navigation.fragment.findNavController
import com.naulian.firstapp.databinding.FragmentMainBinding

class MainFragment : Fragment(R.layout.fragment_main) {
    private lateinit var viewBinding: FragmentMainBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewBinding = FragmentMainBinding.bind(view)

        viewBinding.apply {
            val txtList = arrayListOf(
                "Page 0",
                "Page 1",
                "Page 2",
                "Page 3",
                "Page 4",
                "Page 5"
            )

            list.adapter = ArrayAdapter(
                requireContext(),
                android.R.layout.simple_list_item_1,
                txtList
            )

            val itemClickListener =AdapterView.OnItemClickListener { parent, view, position, id ->
                findNavController().navigate(R.id.action_firstFragmentTo_secondFragment)
                Singleton.currentPage = position
            }
            list.onItemClickListener =  itemClickListener

        }
    }
}