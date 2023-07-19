package com.example.hoppingkotlin.repository.shoppinglist

import com.example.hoppingkotlin.data.entities.ShoppingItem

interface AddClickListenerDialog {
    fun onAddButtonClick(item: ShoppingItem)
}