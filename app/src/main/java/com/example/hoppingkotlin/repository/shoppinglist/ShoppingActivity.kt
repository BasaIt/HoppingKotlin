package com.example.hoppingkotlin.repository.shoppinglist

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.hoppingkotlin.R
import com.example.hoppingkotlin.data.dao.db.ShoppingDataBase
import com.example.hoppingkotlin.data.entities.ShoppingItem
import com.example.hoppingkotlin.repository.ui.ShoppingRepository
import other.ShopingItemAdapter

class ShoppingActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_shopping)

        val rvShoppingView = findViewById<RecyclerView>(R.id.rvShoppingView)
        val fbAdd = findViewById<Button>(R.id.fbAdd)

        val dataBase = ShoppingDataBase(this)
        val repository = ShoppingRepository(dataBase as ShoppingDataBase)
        val factory = ShoppingViewModelFactory(repository)


        val viewModel = ViewModelProviders.of(this, factory)[ShoppingViewModel::class.java]

        val adapter = ShopingItemAdapter(listOf(), viewModel)
        rvShoppingView.layoutManager = LinearLayoutManager(this)
        rvShoppingView.adapter = adapter

        viewModel.getAllShoppingItem().observe(this, Observer {
            adapter.items = it
            adapter.notifyDataSetChanged()
        })

        fbAdd.setOnClickListener {
            AddShoppingItemDialog(this, object : AddClickListenerDialog {
                override fun onAddButtonClick(item: ShoppingItem) {
                    viewModel.upsert(item)
                }
            }).show()
        }
    }
}