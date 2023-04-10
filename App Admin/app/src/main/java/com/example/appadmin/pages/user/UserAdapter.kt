package com.example.appadmin.pages.user

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.appadmin.R
import com.example.appadmin.modals.User

class UserAdapter(private val context: Context, private val items: List<User>) :
    RecyclerView.Adapter<UserAdapter.ViewHolder>() {
    inner class ViewHolder(listItemView: View) : RecyclerView.ViewHolder(listItemView) {
        val iconImageView = listItemView.findViewById<ImageView>(R.id.accountImage)
        val nameTextView = listItemView.findViewById<TextView>(R.id.accountName)
        val descTextView = listItemView.findViewById<TextView>(R.id.accountEmail)
        val createdTextView = listItemView.findViewById<TextView>(R.id.accountDob)
        val phoneTextView = listItemView.findViewById<TextView>(R.id.accountPhone)
        val disableTextView = listItemView.findViewById<ImageView>(R.id.isDisableAccount)
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolder {
        val context = parent.context
        val inflater = LayoutInflater.from(context)
        val contactView = inflater.inflate(R.layout.custom_user, parent, false)
        return ViewHolder(contactView)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item: User = items[position]
        val imageView = holder.iconImageView
        imageView.setImageResource(R.drawable.profile)
        val nameTv = holder.nameTextView
        nameTv.text = item.getName()
        val descTv = holder.descTextView
        descTv.text = item.getEmail()
        val dateTv = holder.createdTextView
        dateTv.text = item.getDob()
        val phoneTv = holder.phoneTextView
        phoneTv.text = item.getPhone()
        val disableIv = holder.disableTextView
        if (item.getIsDisable() == 0) {
            disableIv.setImageResource(R.drawable.baseline_able_24)
        } else {
            disableIv.setImageResource(R.drawable.baseline_disable_24)
        }
        holder.itemView.setOnClickListener {
            println(item)
            val intent = Intent(context, EditUser::class.java)
            intent.putExtra("user_id", item.getId()!!.toString())
            context.startActivity(intent)
        }
    }
}