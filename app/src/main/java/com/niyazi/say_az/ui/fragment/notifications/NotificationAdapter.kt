package com.niyazi.say_az.ui.fragment.notifications


import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.niyazi.say_az.data.NotificationData

class NotificationAdapter :
    ListAdapter<NotificationData, NotificationViewHolder>(NotificationDiffUtil()) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NotificationViewHolder {
        return NotificationViewHolder.from(parent)
    }

    override fun onBindViewHolder(holder: NotificationViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

}