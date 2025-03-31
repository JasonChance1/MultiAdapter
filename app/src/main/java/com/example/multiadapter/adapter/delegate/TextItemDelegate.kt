package com.example.multiadapter.adapter.delegate

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.multiadapter.R
import com.example.multiadapter.adapter.delegate.impl.AdapterDelegate
import com.example.multiadapter.entity.TextItem

class TextItemDelegate : AdapterDelegate {
    override fun isForViewType(items: List<Any>, position: Int): Boolean {
        return items[position] is TextItem
    }

    override fun onCreateViewHolder(parent: ViewGroup): RecyclerView.ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_text, parent, false)
        return TextViewHolder(view)
    }

    override fun onBindViewHolder(items: List<Any>, position: Int, holder: RecyclerView.ViewHolder) {
        val item = items[position] as TextItem
        (holder as TextViewHolder).bind(item)
    }

    private inner class TextViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val textView: TextView = view.findViewById(R.id.tv_text)
        
        fun bind(item: TextItem) {
            textView.text = item.content
        }
    }
}