package com.niyazi.say_az.ui.fragment.dashboard

import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.niyazi.say_az.data.DashboardData
import com.niyazi.say_az.listener.RecyclerViewItemClickListener

/**
 * Created by Niyazi on 12/27/2020.
 */
class DashboardAdapter() :
    ListAdapter<DashboardData, RecyclerView.ViewHolder>(DashboardDiffUtil()) {

    private val DATE_SORT = 0
    private val DASHBOARD = 1

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        if (viewType == DATE_SORT) return DateSortViewHolder.from(parent)
        return DashboardViewHolder.from(parent)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (getItemViewType(position) == DATE_SORT) {
            (holder as DateSortViewHolder).bind(getItem(position).year)
        }else{
            (holder as DashboardViewHolder).bind(getItem(position))
        }
    }

    override fun getItemViewType(position: Int): Int {
        if (getItem(position).imagePath == null) return DATE_SORT
        return DASHBOARD
    }
}