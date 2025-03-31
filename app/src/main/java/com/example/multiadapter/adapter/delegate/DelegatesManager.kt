package com.example.multiadapter.adapter.delegate

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.multiadapter.adapter.delegate.impl.AdapterDelegate

class DelegatesManager {
    private val delegates = mutableListOf<AdapterDelegate>()

    fun addDelegate(delegate: AdapterDelegate): DelegatesManager {
        delegates.add(delegate)
        return this
    }

    fun getItemViewType(items: List<Any>, position: Int): Int {
        delegates.forEachIndexed { index, delegate ->
            if (delegate.isForViewType(items, position)) {
                return index
            }
        }
        throw IllegalArgumentException("下标${position}不存在${items[position].javaClass.simpleName}的委托类型，请先调用addDelegate将该类型添加到delegatesManager中")
    }

    fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return delegates[viewType].onCreateViewHolder(parent)
    }

    fun onBindViewHolder(items: List<Any>, position: Int, holder: RecyclerView.ViewHolder) {
        delegates[holder.itemViewType].onBindViewHolder(items, position, holder)
    }
}