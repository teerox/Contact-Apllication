package com.example.contactapplication.userinterface

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.contactapplication.R
import com.example.contactapplication.databinding.LayoutListitemBinding
import com.example.contactapplication.model.Contact


class ContactAdapter(var context: Context,private var contactArray:ArrayList<Contact>,private val clickListerner:(Contact) -> Unit):RecyclerView.Adapter<ContactAdapter.ViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int):ViewHolder {

        val view = LayoutInflater.from(parent.context)
        val binding = LayoutListitemBinding.inflate(view)
        return ViewHolder(binding)

    }
    override fun getItemCount(): Int {
        return contactArray.size
    }
    override fun onBindViewHolder(holder:ViewHolder, position: Int) = holder.bind(contactArray[position],clickListerner)
    class ViewHolder(private var binding: LayoutListitemBinding):RecyclerView.ViewHolder(binding.root){
        fun bind(item:Contact,clickListerner: (Contact) -> Unit){
            binding.root.setOnClickListener {
                clickListerner(item)
            }
            binding.contacts = item
            Glide.with(binding.root.context).asBitmap().error(R.drawable.image_round).load(item.image).into(binding.smallimage)
        }
    }
}