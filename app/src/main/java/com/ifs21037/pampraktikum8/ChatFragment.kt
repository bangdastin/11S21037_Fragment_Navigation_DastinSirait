package com.ifs21037.pampraktikum8

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.ifs21037.pampraktikum8.databinding.FragmentChatBinding

class ChatFragment : Fragment() {
    private lateinit var binding: FragmentChatBinding
    private val dataChat = ArrayList<Chat>()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentChatBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.rvChat.setHasFixedSize(true)
        initData()
        setupRecyclerView()


    }

    private fun initData() {
        val dataName = resources.getStringArray(R.array.nama_kontak)
        val dataIcon = resources.obtainTypedArray(R.array.chat_icon)

        for (i in dataName.indices) {
            val chat = Chat(dataName[i], dataIcon.getResourceId(i, -1))
            dataChat.add(chat)
        }

        dataIcon.recycle()
    }



    private fun setupRecyclerView() {
        val adapter = ListAdapterChat(dataChat)
        binding.rvChat.layoutManager = LinearLayoutManager(requireContext())
        binding.rvChat.adapter = adapter

        adapter.setOnItemClickCallback(object : ListAdapterChat.OnItemClickCallback {
            override fun onItemClicked(data: Chat) {
                // Handle item click
            }
        })
    }

}
