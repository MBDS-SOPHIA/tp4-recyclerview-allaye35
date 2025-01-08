package com.openclassrooms.magicgithub.ui.user_list

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.openclassrooms.magicgithub.R
import com.openclassrooms.magicgithub.databinding.ItemListUserBinding
import com.openclassrooms.magicgithub.model.User
import com.openclassrooms.magicgithub.utils.UserDiffCallback

class UserListAdapter(private val callback: Listener) : RecyclerView.Adapter<ListUserViewHolder>() {

    private var users: MutableList<User> = mutableListOf()
    private val activeStates: MutableMap<String, Boolean> = mutableMapOf()

    interface Listener {
        fun onClickDelete(user: User)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListUserViewHolder {
        val binding = ItemListUserBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ListUserViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ListUserViewHolder, position: Int) {
        val user = users[position]
        holder.bind(user, activeStates[user.id] ?: true, callback) { isActive ->
            activeStates[user.id] = isActive
        }
    }

    override fun getItemCount(): Int = users.size

    fun updateList(newList: List<User>) {
        val diffResult = DiffUtil.calculateDiff(UserDiffCallback(newList, users))
        users.clear()
        users.addAll(newList)
        diffResult.dispatchUpdatesTo(this)
    }

    fun toggleUserState(position: Int) {
        val user = users[position]
        val isActive = !(activeStates[user.id] ?: true)
        activeStates[user.id] = isActive
        notifyItemChanged(position)
    }

    fun onItemMove(fromPosition: Int, toPosition: Int) {
        val fromUser = users.removeAt(fromPosition)
        users.add(toPosition, fromUser)
        notifyItemMoved(fromPosition, toPosition)
    }
}