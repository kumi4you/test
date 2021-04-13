package com.kumar.test.presentation.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.kumar.test.R
import com.kumar.test.presentation.viewmodel.UserViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {

    private val viewModel: UserViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel.getUserList()

        setObservers()
    }

    private fun setObservers(){

        viewModel.userList.observe(this, {

        })
    }
}