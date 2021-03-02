package com.niyazi.say_az.ui.fragment.dashboard

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.niyazi.say_az.data.DashboardData
import com.niyazi.say_az.databinding.ListItemDashboardBinding

/**
 * Created by Niyazi on 12/27/2020.
 */
class DashboardViewHolder(private val binding: ListItemDashboardBinding) :
    RecyclerView.ViewHolder(binding.root) {

    fun bind(
        item: DashboardData
    ) {
        binding.apply {
            item.imagePath?.let { imageViewDashboard.setImageResource(it) }
        }
    }

    companion object {
        fun from(parent: ViewGroup): DashboardViewHolder {
            val layoutInflater = LayoutInflater.from(parent.context)
            val binding = ListItemDashboardBinding.inflate(layoutInflater, parent, false)
            return DashboardViewHolder(binding)
        }
    }

}