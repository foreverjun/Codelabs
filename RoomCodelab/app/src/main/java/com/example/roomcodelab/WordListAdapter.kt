package com.example.roomcodelab

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView

class WordListAdapter : ListAdapter<Word, WordListAdapter.WordViewHolder>(WordsComparator()) {



    class WordViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private val wordItemView = itemView.findViewById<TextView>(R.id.textView)

        fun bind(text : String?) {
            wordItemView.text = text
        }

    }
    class WordsComparator : DiffUtil.ItemCallback<Word>(){
        override fun areItemsTheSame(oldItem: Word, newItem: Word): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: Word, newItem: Word): Boolean {
            return oldItem.word == newItem.word
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WordViewHolder {
        return WordViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.recyclerview_item, parent, false))
    }

    override fun onBindViewHolder(holder: WordViewHolder, position: Int) {
        val current = getItem(position)
        holder.bind(current.word)
    }
}