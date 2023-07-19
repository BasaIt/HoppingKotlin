package com.example.hoppingkotlin.repository.shoppinglist

import androidx.lifecycle.ViewModel
import com.example.hoppingkotlin.data.entities.ShoppingItem
import com.example.hoppingkotlin.repository.ui.ShoppingRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ShoppingViewModel(
    private val repository: ShoppingRepository
) : ViewModel() {
    fun upsert(item: ShoppingItem) = CoroutineScope(Dispatchers.Main).launch {
        repository.upsert(item)
    }

    fun delete(item: ShoppingItem) = CoroutineScope(Dispatchers.Main).launch {
        repository.delete(item)
    }

    fun getAllShoppingItem() = repository.getAllShoppingItem()
}