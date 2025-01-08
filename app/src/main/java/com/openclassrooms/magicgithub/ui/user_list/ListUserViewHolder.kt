package com.openclassrooms.magicgithub.ui.user_list

import android.view.View
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.openclassrooms.magicgithub.R
import com.openclassrooms.magicgithub.databinding.ItemListUserBinding
import com.openclassrooms.magicgithub.model.User

class ListUserViewHolder(private val binding: ItemListUserBinding) : RecyclerView.ViewHolder(binding.root) {

    fun bind(user: User, isActive: Boolean, callback: UserListAdapter.Listener, onStateChange: (Boolean) -> Unit) {
        with(binding) {
            Glide.with(root.context)
                .load(user.avatarUrl)
                .apply(RequestOptions.circleCropTransform())
                .into(itemListUserAvatar)

            itemListUserUsername.text = user.login

            root.setBackgroundColor(
                if (isActive) ContextCompat.getColor(root.context, android.R.color.white)
                else ContextCompat.getColor(root.context, android.R.color.holo_red_light)
            )

            itemListUserDeleteButton.setOnClickListener { callback.onClickDelete(user) }
            root.setOnClickListener { onStateChange(!isActive) }
        }
    }
}
