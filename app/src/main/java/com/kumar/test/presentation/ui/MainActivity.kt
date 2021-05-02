package com.kumar.test.presentation.ui

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.kumar.test.data.model.ShowResponse
import com.kumar.test.databinding.ActivityMainBinding
import com.kumar.test.presentation.viewmodel.ShowViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {

    private val viewModel: ShowViewModel by viewModel()
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        setObservers()

        binding.searchButton.setOnClickListener {
            viewModel.getShowList(binding.editTextSearch.text.toString())
        }

        binding.buttonTitleSort.setOnClickListener {
            viewModel.sortByTitle()
        }

        binding.buttonScoreSort.setOnClickListener {
            viewModel.sortByScore()
        }

        binding.buttonTimeSort.setOnClickListener {
            viewModel.sortByTime()
        }

    }


    private fun setObservers() {

        viewModel.showList.observe(this, {
            setupAdapter(it)
        })
        viewModel.selectedShow.observe(this, {
            showSelectedUserInfo(it)
        }
        )
    }

    private fun showSelectedUserInfo(showResponse: ShowResponse) {
        Log.e("Kumi", "response ${showResponse.show.name}")
    }

    private fun setupAdapter(list: List<ShowResponse>) {
        val recyclerView = binding.usersRecyclerView

        recyclerView.layoutManager = LinearLayoutManager(this)

        val adapter = ShowsAdapter(list) {
            viewModel.onItemSelect(it)
        }
        recyclerView.addItemDecoration(
            DividerItemDecoration(this,
            LinearLayoutManager.VERTICAL)
        )
        recyclerView.adapter = adapter
    }
}