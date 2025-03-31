package com.example.multiadapter.adapter.delegate

import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.multiadapter.R
import com.example.multiadapter.adapter.delegate.impl.AdapterDelegate
import com.example.multiadapter.entity.CompoundItem

class CompoundDelegate : AdapterDelegate {
    override fun isForViewType(items: List<Any>, position: Int): Boolean {
        return items[position] is CompoundItem
    }

    override fun onCreateViewHolder(parent: ViewGroup): RecyclerView.ViewHolder {
        return CompoundViewHolder(View.inflate(parent.context, R.layout.item_compound, null))
    }

    override fun onBindViewHolder(
        items: List<Any>,
        position: Int,
        holder: RecyclerView.ViewHolder
    ) {
        val item = items[position] as CompoundItem
        (holder as CompoundViewHolder).apply {
            textView.text = item.content
            ivCover.setImageResource(item.resId)
        }
    }

    class CompoundViewHolder(view:View) : RecyclerView.ViewHolder(view){
        val textView = view.findViewById<TextView>( R.id.tv_content)
        val ivCover = view.findViewById<ImageView>(R.id.iv_cover)
    }
}