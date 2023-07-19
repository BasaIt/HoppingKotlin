package com.example.hoppingkotlin.repository.ui

import com.example.hoppingkotlin.data.dao.db.ShoppingDataBase
import com.example.hoppingkotlin.data.entities.ShoppingItem

class ShoppingRepository (
    private val db : ShoppingDataBase
        ){
    suspend fun upsert(item:ShoppingItem) = db.getShoppingDao().upsert(item)

    suspend fun delete(item: ShoppingItem) = db.getShoppingDao().delete(item)

    fun getAllShoppingItem() = db.getShoppingDao().getAllShoppingItem()
}