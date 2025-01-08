package com.openclassrooms.magicgithub.ui.user_list

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.openclassrooms.magicgithub.R
import com.openclassrooms.magicgithub.databinding.ActivityListUserBinding
import com.openclassrooms.magicgithub.di.Injection.getRepository
import com.openclassrooms.magicgithub.model.User

class ListUserActivity : AppCompatActivity(), UserListAdapter.Listener {
    private lateinit var binding: ActivityListUserBinding
    private lateinit var adapter: UserListAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityListUserBinding.inflate(layoutInflater)
        setContentView(binding.root)

        configureRecyclerView()
        configureFab()
    }

    override fun onResume() {
        super.onResume()
        loadData()
    }

    private fun configureRecyclerView() {
        adapter = UserListAdapter(this)
        binding.activityListUserRv.layoutManager = LinearLayoutManager(this)
        binding.activityListUserRv.adapter = adapter

        val itemTouchHelperCallback = object : ItemTouchHelper.SimpleCallback(
            ItemTouchHelper.UP or ItemTouchHelper.DOWN, // Allow drag & drop
            ItemTouchHelper.LEFT or ItemTouchHelper.RIGHT // Allow swipe actions
        ) {
            override fun onMove(
                recyclerView: RecyclerView,
                viewHolder: RecyclerView.ViewHolder,
                target: RecyclerView.ViewHolder
            ): Boolean {
                adapter.onItemMove(viewHolder.adapterPosition, target.adapterPosition)
                return true
            }

            override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
                val position = viewHolder.adapterPosition
                adapter.toggleUserState(position)
            }
        }

        val itemTouchHelper = ItemTouchHelper(itemTouchHelperCallback)
        itemTouchHelper.attachToRecyclerView(binding.activityListUserRv)
    }

    private fun configureFab() {
        binding.activityListUserFab.setOnClickListener {
            getRepository().addRandomUser()
            loadData()
        }
    }

    private fun loadData() {
        adapter.updateList(getRepository().getUsers())
    }

    override fun onClickDelete(user: User) {
        getRepository().deleteUser(user)
        loadData()
    }
}