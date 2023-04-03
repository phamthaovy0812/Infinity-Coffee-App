package com.example.appadmin.product

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.appadmin.Product
import com.example.appadmin.R

class Products : AppCompatActivity() {
    private val productItems = ArrayList<Product>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_product)

        productItems.add(
            Product(
                "0",
                "0",
                "0",
                0.0,
                "0",
                0.0,
                0.0,
                0.0,
                "0",
                "0",
                false,
                "0",
                "0",
                "0",
                0
            )
        )

        productItems.add(
            Product(
                "0",
                "0",
                "0",
                0.0,
                "0",
                0.0,
                0.0,
                0.0,
                "0",
                "0",
                false,
                "0",
                "0",
                "0",
                0
            )
        )

        productItems.add(
            Product(
                "0",
                "0",
                "0",
                0.0,
                "0",
                0.0,
                0.0,
                0.0,
                "0",
                "0",
                false,
                "0",
                "0",
                "0",
                0
            )
        )

        val adapter = ProductAdapter(this, productItems)

        val rvProduct = findViewById<RecyclerView>(R.id.productRV)

        rvProduct.adapter = adapter

        rvProduct.layoutManager = LinearLayoutManager(this)
    }
}