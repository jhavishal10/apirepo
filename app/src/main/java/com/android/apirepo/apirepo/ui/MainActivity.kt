package com.android.apirepo.apirepo.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.android.apirepo.R
import com.android.apirepo.apirepo.model.DetailItem


class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: ViewModel
    private val adapter = CustomAdapter()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        viewModel = ViewModelProviders.of(this).get(ViewModel::class.java)

        viewModel.users.observe(this, Observer { users: List<DetailItem.Item> ->
            adapter.addUsers(users)

        })
        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)
        recyclerView.adapter = adapter
    }
}
