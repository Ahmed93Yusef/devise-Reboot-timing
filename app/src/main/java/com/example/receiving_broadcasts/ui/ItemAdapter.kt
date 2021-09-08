package com.example.receiving_broadcasts.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.receiving_broadcasts.R
import com.example.receiving_broadcasts.databinding.ItemBinding

class ItemAdapter(private val list: List<String>) : RecyclerView.Adapter<ItemAdapter.ItemViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item,parent,false)
        return ItemViewHolder(view)
    }
    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val currentDate = list[position]
        holder.binding.apply {
            textDate.isSelected = true
            textDate.text = currentDate
        }
    }
    override fun getItemCount() = list.size

    class ItemViewHolder(viewItem: View) : RecyclerView.ViewHolder(viewItem) {
        val binding = ItemBinding.bind(viewItem)
    }
}