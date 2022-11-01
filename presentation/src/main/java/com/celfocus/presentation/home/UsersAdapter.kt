package com.celfocus.presentation.home

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.celfocus.model.User
import com.celfocus.presentation.databinding.ViewUserBinding

class UsersAdapter constructor(private val context: Context, private val listener: (User) -> Unit) : RecyclerView.Adapter<UsersAdapter.ViewHolder>()
{
    private var users: MutableList<User> = mutableListOf()

    fun setData(users: MutableList<User>)
    {
        this.users = mutableListOf()
        this.users.addAll(users)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder = ViewHolder(ViewUserBinding.inflate(LayoutInflater.from(parent.context), parent, false))

    override fun getItemCount(): Int = users.size

    private fun getItem(position: Int) = users[position]

    override fun onBindViewHolder(holder: ViewHolder, position: Int)
    {
        val user = getItem(position)
        Glide.with(context).load(user.avatar).into(holder.binding.avatar)
        val name = "${user.firstName} ${user.lastName}"
        holder.binding.name.text = name
    }

    inner class ViewHolder(val binding: ViewUserBinding) : RecyclerView.ViewHolder(binding.root)
    {
        init
        {
            binding.root.setOnClickListener { listener(getItem(layoutPosition)) }
        }
    }
}