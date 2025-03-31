package com.example.multiadapter.adapter.delegate.impl

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

interface AdapterDelegate {
    // 判断是否处理当前数据类型
    fun isForViewType(items: List<Any>, position: Int): Boolean

    // 创建对应的 ViewHolder
    fun onCreateViewHolder(parent: ViewGroup): RecyclerView.ViewHolder

    // 绑定数据到 ViewHolder
    fun onBindViewHolder(items: List<Any>, position: Int, holder: RecyclerView.ViewHolder)
}