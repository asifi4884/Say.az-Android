package com.niyazi.say_az.ui.fragment.invoice

import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.niyazi.say_az.data.InvoiceData
import com.niyazi.say_az.ui.fragment.dashboard.DateSortViewHolder

class InvoiceAdapter : ListAdapter<InvoiceData, RecyclerView.ViewHolder>(InvoiceDiffUtil()) {

    private val DATE_SORT = 0
    private val INVOICE = 1

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        if (viewType == DATE_SORT) return DateSortViewHolder.from(parent)
        return InvoiceViewHolder.from(parent)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (getItemViewType(position) == DATE_SORT) {
            (holder as DateSortViewHolder).bind(getItem(position).year)
        } else {
            (holder as InvoiceViewHolder).bind(getItem(position))
        }
    }

    override fun getItemViewType(position: Int): Int {
        if (getItem(position).number == null) return DATE_SORT
        return INVOICE
    }


}