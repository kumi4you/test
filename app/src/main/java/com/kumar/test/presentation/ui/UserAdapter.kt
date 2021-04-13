package com.kumar.test.presentation.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.kumar.test.R
import com.kumar.test.data.model.UserResponse

class UserAdapter(
    private var userInfoList: List<UserResponse>,
    private val userInfoListener: (UserResponse) -> Unit
) : RecyclerView.Adapter<UserAdapter.UserViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.item_user_info, parent, false)
        view.isClickable = true
        return UserViewHolder(view)
    }

    override fun getItemCount(): Int = userInfoList.size

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {

        val userInfo = userInfoList[position]

        holder.name.text = userInfo.name
        holder.email.text = userInfo.email

        holder.layout.setOnClickListener {
            userInfoListener(userInfo)
        }
    }

    class UserViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var layout: ConstraintLayout = itemView.findViewById(R.id.userInfoLayout)
        var name: TextView = itemView.findViewById(R.id.textViewUserName)
        var email: TextView = itemView.findViewById(R.id.textViewUserEmail)
    }
}