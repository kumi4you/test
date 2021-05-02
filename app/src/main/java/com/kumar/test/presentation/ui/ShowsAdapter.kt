package com.kumar.test.presentation.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.kumar.test.R
import com.kumar.test.data.model.ShowResponse

class ShowsAdapter(
    private var showInfoList: List<ShowResponse>,
    private val showInfoListener: (ShowResponse) -> Unit
) : RecyclerView.Adapter<ShowsAdapter.UserViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.item_user_info, parent, false)
        view.isClickable = true
        return UserViewHolder(view)
    }

    override fun getItemCount(): Int = showInfoList.size

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {

        val showResponse = showInfoList[position]

        holder.name.text = showResponse.show.name
        holder.email.text = showResponse.score.toString()

        holder.layout.setOnClickListener {
            showInfoListener(showResponse)
        }
    }

    class UserViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var layout: ConstraintLayout = itemView.findViewById(R.id.userInfoLayout)
        var name: TextView = itemView.findViewById(R.id.textViewUserName)
        var email: TextView = itemView.findViewById(R.id.textViewUserEmail)

    }
}