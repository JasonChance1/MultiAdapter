package com.example.multiadapter

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.multiadapter.adapter.TestAdapter
import com.example.multiadapter.adapter.delegate.CompoundDelegate
import com.example.multiadapter.adapter.delegate.DelegatesManager
import com.example.multiadapter.adapter.delegate.ImageDelegate
import com.example.multiadapter.adapter.delegate.TextItemDelegate
import com.example.multiadapter.entity.CompoundItem
import com.example.multiadapter.entity.ImageItem
import com.example.multiadapter.entity.TextItem
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

    private val dataList = mutableListOf<Any>()
    private lateinit var recyclerView: RecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        initData()
        initRecyclerView()
    }

    private fun initData() {
        for (i in 0 until 9) {
            Random.nextInt(1, 4).let {
                when (it) {
                    1 -> {
                        dataList.add(TextItem("纯文本 $i"))
                    }

                    2 -> {
                        dataList.add(ImageItem(R.drawable.test))
                    }

                    else -> {
                        dataList.add(CompoundItem("混合 $i", R.drawable.test))
                    }

                }
            }
        }
    }

    private fun initRecyclerView() {
        recyclerView = findViewById(R.id.recyclerView)
        val delegatesManager = DelegatesManager().also {
            it.addDelegate(TextItemDelegate()).addDelegate(ImageDelegate())
                .addDelegate(CompoundDelegate())
        }
        recyclerView.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            addItemDecoration(DividerItemDecoration(this@MainActivity, DividerItemDecoration.VERTICAL))
            adapter = TestAdapter(dataList, delegatesManager)
        }
    }
}