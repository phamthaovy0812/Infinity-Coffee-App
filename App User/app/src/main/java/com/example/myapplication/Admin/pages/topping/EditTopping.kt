package com.example.myapplication.Admin.pages.topping

import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.myapplication.Admin.controllers.CategoryController
import com.example.myapplication.Admin.controllers.ToppingController
import com.example.myapplication.Admin.modals.Category
import com.example.myapplication.Admin.modals.Topping
import com.example.myapplication.R

class EditTopping : AppCompatActivity() {
    private lateinit var categories: List<Category>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_topping)

        val name = findViewById<EditText>(R.id.editToppingName)
        val price = findViewById<EditText>(R.id.editToppingPrice)
        val category = findViewById<Spinner>(R.id.editToppingCategory)

        val intent = intent
        val id = intent.getStringExtra("toppingId")

        val categoryViewProvider = ViewModelProvider(this)[CategoryController::class.java]
        categoryViewProvider.getAllCategory().observe(this) {
            categories = it
            categories = categories.reversed()
            val toppingsListName = mutableListOf<String>()
            for (topping in categories) {
                topping.getName()?.let { it1 -> toppingsListName.add(it1) }
            }
            ArrayAdapter(
                this,
                android.R.layout.simple_spinner_item,
                toppingsListName
            ).also { adapter ->
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
                category.adapter = adapter
            }
        }

        val toppingViewProvider = ViewModelProvider(this)[ToppingController::class.java]
        toppingViewProvider.getTopping(id!!.toInt()).observe(this) {
            name.setText(it.getName())
            price.setText(it.getPrice().toString())
            category.setSelection(it.getCategory_id()!! - 1)
        }

        findViewById<Button>(R.id.editTopping_cancelBtn).setOnClickListener {
            val intent = Intent(this, Toppings::class.java)
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_NEW_TASK)
            startActivity(intent)
            finish()
        }

        findViewById<Button>(R.id.editTopping_saveBtn).setOnClickListener {
            val topping = Topping(
                categories[category.selectedItemPosition].getId(),
                name.text.toString(),
                price.text.toString().toDouble(),
                0,
                1
            )

            toppingViewProvider.updateTopping(id!!.toInt(), topping).observe(this) {

            }
            val intent = Intent(this, Toppings::class.java)
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_NEW_TASK)
            startActivity(intent)
        }
    }
}