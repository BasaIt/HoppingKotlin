package com.example.hoppingkotlin.repository.shoppinglist

import android.content.Context
import android.os.Bundle
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatDialog
import com.example.hoppingkotlin.R
import com.example.hoppingkotlin.data.entities.ShoppingItem


class AddShoppingItemDialog(context: Context, var addClickListenerDialog: AddClickListenerDialog) :
    AppCompatDialog(context) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val tvAdd = findViewById<TextView>(R.id.tvAdd)
        val etName = findViewById<EditText>(R.id.etName)
        val etAmount = findViewById<EditText>(R.id.etAmount)
        val tvCancle = findViewById<TextView>(R.id.tvCancle)

        if (tvAdd != null) {
            tvAdd.setOnClickListener {
                val name = etName?.text.toString()
                val amount = etAmount?.text.toString()
                if (name.isEmpty() || amount.isEmpty()) {
                    Toast.makeText(context, "Please entre all the information", Toast.LENGTH_LONG)
                        .show()
                    return@setOnClickListener
                }

                val item = ShoppingItem(name, amount.toInt())
                addClickListenerDialog.onAddButtonClick(item)
                dismiss()
            }
        }

        if (tvCancle != null) {
            tvCancle.setOnClickListener {
                cancel()
            }
        }
    }
}

