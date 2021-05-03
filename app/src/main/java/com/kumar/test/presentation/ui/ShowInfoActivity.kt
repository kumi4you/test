package com.kumar.test.presentation.ui

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.kumar.test.data.model.ShowResponse
import com.kumar.test.databinding.ActivityShowInfoBinding

class ShowInfoActivity : AppCompatActivity() {

    companion object {
        const val KEY_SHOW_RESPONSE = "showResponse"
        fun launchActivity(activity: AppCompatActivity, showResponse: ShowResponse) {

            val intent = Intent(activity, ShowInfoActivity::class.java)

            intent.putExtra(KEY_SHOW_RESPONSE, showResponse)

            activity.startActivity(intent)
        }
    }

    private lateinit var binding: ActivityShowInfoBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityShowInfoBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        val showResponse: ShowResponse =
            intent.getSerializableExtra(KEY_SHOW_RESPONSE) as ShowResponse

        setViews(showResponse)

    }

    private fun setViews(showResponse: ShowResponse) {
        binding.textViewShowTitle.text = showResponse.show.name
        binding.textViewSummary.text = showResponse.show.summary
        binding.textViewStatus.text = showResponse.show.status

    }
}