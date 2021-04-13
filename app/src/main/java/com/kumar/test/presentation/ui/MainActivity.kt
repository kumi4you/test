package com.kumar.test.presentation.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.kumar.test.data.model.UserResponse
import com.kumar.test.databinding.ActivityMainBinding
import com.kumar.test.presentation.viewmodel.UserViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {

    private val viewModel: UserViewModel by viewModel()
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        viewModel.getUserList()

        setObservers()
    }

    private fun setObservers() {

        viewModel.userList.observe(this, {
            setupAdapter(it)
        })
        viewModel.selectedUser.observe(this, {
            showSelectedUserInfo(it)
        }
        )
    }

    private fun showSelectedUserInfo(userResponse: UserResponse) {
        binding.textViewEmail.text = userResponse.email ?: ""
        binding.textViewName.text = userResponse.name ?: ""
        binding.textViewPhone.text = userResponse.phone ?: ""
        binding.textViewWebsite.text = userResponse.website ?: ""
    }

    private fun setupAdapter(list: List<UserResponse>) {
       val recyclerView = binding.usersRecyclerView

        recyclerView.layoutManager = LinearLayoutManager(this)

        val adapter = UserAdapter(list) {
            viewModel.onItemSelect(it)
        }
        recyclerView.adapter = adapter
    }
}