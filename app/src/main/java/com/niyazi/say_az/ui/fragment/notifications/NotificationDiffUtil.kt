package com.niyazi.say_az.ui.fragment.notifications

import androidx.recyclerview.widget.DiffUtil
import com.niyazi.say_az.data.DashboardData
import com.niyazi.say_az.data.NotificationData

/**
 * Created by Niyazi on 12/27/2020.
 */
class NotificationDiffUtil : DiffUtil.ItemCallback<NotificationData>() {
    override fun areItemsTheSame(oldItem: NotificationData, newItem: NotificationData): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: NotificationData, newItem: NotificationData): Boolean {
        return oldItem == newItem
    }

}