package com.example.appadmin.account

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.appadmin.Account
import com.example.appadmin.Product
import com.example.appadmin.R
import com.example.appadmin.product.EditProduct
import com.example.appadmin.product.ProductAdapter

class AccountAdapter(private val context: Context, private val items: List<Account>) :
    RecyclerView.Adapter<AccountAdapter.ViewHolder>() {
    inner class ViewHolder(listItemView: View) : RecyclerView.ViewHolder(listItemView) {
        val iconImageView = listItemView.findViewById<ImageView>(R.id.accountImage)
        val nameTextView = listItemView.findViewById<TextView>(R.id.accountName)
        val descTextView = listItemView.findViewById<TextView>(R.id.accountEmail)
        val createdTextView = listItemView.findViewById<TextView>(R.id.accountDob)
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): AccountAdapter.ViewHolder {
        val context = parent.context
        val inflater = LayoutInflater.from(context)
        val contactView = inflater.inflate(R.layout.custom_account, parent, false)
        return ViewHolder(contactView)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: AccountAdapter.ViewHolder, position: Int) {
        val item: Account = items[position]
        val imageView = holder.iconImageView
        imageView.setImageResource(R.drawable.profile)
        val nameTv = holder.nameTextView
        nameTv.text = item.fullname
        val descTv = holder.descTextView
        descTv.text = item.email
        val dateTv = holder.createdTextView
        dateTv.text = item.dob
        holder.itemView.setOnClickListener {
            val intent = Intent(context, EditAccount::class.java)
            intent.putExtra("product_detail", item.toString())
            context.startActivity(intent)
        }
    }
}