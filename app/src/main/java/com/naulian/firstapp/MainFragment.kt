package com.naulian.firstapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import android.view.animation.GridLayoutAnimationController
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.LinearLayout
import android.widget.ListAdapter
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.naulian.firstapp.databinding.FragmentMainBinding

class MainFragment : Fragment(R.layout.fragment_main) {
    private lateinit var viewBinding: FragmentMainBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewBinding = FragmentMainBinding.bind(view)

        viewBinding.apply {
            val articles = arrayListOf(
                Article(title = "Title 0", content = "Content 0"),
                Article(title = "Title 1", content = "Content 1"),
                Article(title = "Title 2", content = "Content 2"),
                Article(title = "Title 3", content = "Content 3"),
                Article(title = "Title 4", content = "Content 4"),
                Article(title = "Title 5", content = "Content 5"),
            )

            val articleAdapter = Adapter()
            articleAdapter.submitList(articles)

            val linearLayoutManager = LinearLayoutManager(requireContext())
            linearLayoutManager.orientation = LinearLayoutManager.VERTICAL

            val clickListener = object : Adapter.ClickListener {
                override fun onClick(article: Article) {
                    val direction = MainFragmentDirections
                        .actionFirstFragmentToSecondFragment(article)
                    findNavController().navigate(direction)
                }
            }
            articleAdapter.setOnClickListener(clickListener)

            list.apply {
                layoutManager = linearLayoutManager
                adapter = articleAdapter
            }
        }
    }
}