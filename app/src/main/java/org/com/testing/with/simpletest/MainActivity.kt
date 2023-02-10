package org.com.testing.with.simpletest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private var recyclerView: RecyclerView? = null
    private val viewModel by lazy {
        MainViewModel()
    }
    private val adapter by lazy {
        RVCustomAdapter()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        recyclerView = findViewById<RecyclerView>(R.id.mRecyclerView)
        setObserve()
    }

    private fun setObserve() {
        viewModel.data.observe(this, Observer { list ->
            adapter.setData(list)
            recyclerView?.apply {
                layoutManager = LinearLayoutManager(this?.context)
                adapter = this.adapter
            }
        })
    }
}