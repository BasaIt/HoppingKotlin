package com.example.hoppingkotlin.data.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.*
import com.example.hoppingkotlin.data.entities.ShoppingItem

@Dao()
interface ShoppingDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun upsert(item : ShoppingItem)

    @Delete
    fun delete(item: ShoppingItem)

    @Query("SELECT * FROM shopping_items" )
    fun getAllShoppingItem():LiveData<List<ShoppingItem>>

}