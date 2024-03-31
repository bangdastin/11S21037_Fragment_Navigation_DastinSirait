package com.ifs21037.pampraktikum8

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ifs21037.pampraktikum8.databinding.ItemRowChatBinding

class ListAdapterChat(private val listBmw: ArrayList<Chat>) :
    RecyclerView.Adapter<ListAdapterChat.ListViewHolder>() {
    private lateinit var onItemClickCallback: OnItemClickCallback
    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback
    }
    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType:
    Int): ListViewHolder {
        val binding =
            ItemRowChatBinding.inflate(LayoutInflater.from(viewGroup.context),
                viewGroup, false)
        return ListViewHolder(binding)
    }
    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: ListViewHolder, position:
    Int) {
        val chat = listBmw[position]
        holder.binding.ivItemFruit.setImageResource(chat.icon)
        holder.binding.tvItemFruit.text = chat.kontak
        holder.itemView.setOnClickListener {
            onItemClickCallback
                .onItemClicked(listBmw[holder.adapterPosition])
        }
    }
    override fun getItemCount(): Int = listBmw.size
    class ListViewHolder(var binding: ItemRowChatBinding) :
        RecyclerView.ViewHolder(binding.root)
    interface OnItemClickCallback {
        fun onItemClicked(data: Chat)
    }
}
