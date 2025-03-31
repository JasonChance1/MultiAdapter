package com.example.multiadapter.adapter.delegate

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.example.multiadapter.R
import com.example.multiadapter.adapter.delegate.impl.AdapterDelegate
import com.example.multiadapter.entity.ImageItem

class ImageDelegate : AdapterDelegate {
    override fun isForViewType(items: List<Any>, position: Int): Boolean {
        return items[position] is ImageItem
    }

    override fun onCreateViewHolder(parent: ViewGroup): RecyclerView.ViewHolder {
        return ImageViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_image, parent, false)
        )
    }

    override fun onBindViewHolder(
        items: List<Any>,
        position: Int,
        holder: RecyclerView.ViewHolder
    ) {
        val item = items[position] as ImageItem
        (holder as ImageViewHolder).ivCover.setImageResource(item.resId)
    }

    private class ImageViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val ivCover = view.findViewById<ImageView>(R.id.iv_cover)
    }
}