package com.programming.android.sdu.externallibraryexercise

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private lateinit var mRecyclerView: RecyclerView
    private lateinit var mAdapter: RecyclerView.Adapter<*>
    private lateinit var mLayoutManager: RecyclerView.LayoutManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mRecyclerView = findViewById(R.id.my_recycler_view)
        mRecyclerView.setHasFixedSize(true)
        mLayoutManager = GridLayoutManager(this, 2)
        mRecyclerView.layoutManager = mLayoutManager
        mAdapter = RandomPicturesAdapter(this)
        mRecyclerView.adapter = mAdapter
    }

}