package com.niyazi.say_az.ui.fragment.dashboard

import androidx.recyclerview.widget.DiffUtil
import com.niyazi.say_az.data.DashboardData

/**
 * Created by Niyazi on 12/27/2020.
 */
class DashboardDiffUtil : DiffUtil.ItemCallback<DashboardData>() {
    override fun areItemsTheSame(oldItem: DashboardData, newItem: DashboardData): Boolean {
        return oldItem.year== newItem.year
    }

    override fun areContentsTheSame(oldItem: DashboardData, newItem: DashboardData): Boolean {
        return oldItem == newItem
    }

}