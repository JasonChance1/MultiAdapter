package com.example.multiadapter.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.multiadapter.adapter.delegate.DelegatesManager

class TestAdapter(private val dataList: List<Any>, private val delegatesManager: DelegatesManager) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return delegatesManager.onCreateViewHolder(parent, viewType)
    }

    override fun getItemCount(): Int {
        return dataList.size
    }

    override fun getItemViewType(position: Int): Int {
        return delegatesManager.getItemViewType(dataList, position)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        return delegatesManager.onBindViewHolder(dataList, position, holder)
    }
}