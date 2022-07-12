package com.naulian.firstapp

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.naulian.firstapp.databinding.ItemLayoutBinding

class Adapter : ListAdapter<Article , Adapter.ViewHolder>(ItemDiffUtil()) {
     private var clickListener : ClickListener? = null

    inner class ViewHolder(val binding: ItemLayoutBinding) : RecyclerView.ViewHolder(binding.root){

        fun bind(position: Int){
               val article = getItem(position)

               binding.apply {
                   txtCap.text = article.title[0].toString()
                   txtTitle.text = article.title

                   root.setOnClickListener {
                       clickListener?.onClick(article)
                   }
               }
           }
    }
    fun setOnClickListener(listener: ClickListener){
        clickListener = listener
    }

    interface ClickListener{
        fun onClick(article: Article)
    }


    class ItemDiffUtil : DiffUtil.ItemCallback<Article>(){
        override fun areItemsTheSame(oldItem: Article, newItem: Article): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: Article, newItem: Article): Boolean {
            return oldItem.content == newItem.content
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = ItemLayoutBinding.inflate(layoutInflater)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(position)
    }
}