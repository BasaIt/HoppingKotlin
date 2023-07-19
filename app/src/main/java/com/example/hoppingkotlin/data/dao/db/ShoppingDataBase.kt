package com.example.hoppingkotlin.data.dao.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.hoppingkotlin.data.dao.ShoppingDao
import com.example.hoppingkotlin.data.entities.ShoppingItem


@Database(
    entities = [ShoppingItem ::class],
    version = 1
)
abstract class ShoppingDataBase : RoomDatabase(){
    abstract fun getShoppingDao(): ShoppingDao

    companion object {
        private var instance: ShoppingDataBase? = null

        private val LOCK = Any()

        operator fun invoke(context: Context) = instance ?: synchronized(LOCK){
            instance ?: createDataBase(context).also { it }
        }

        private fun createDataBase(context: Context) {
            Room.databaseBuilder(
                context.applicationContext,
                ShoppingDataBase::class.java, "ShoppingDB.db"
            ).build()
        }
    }
}