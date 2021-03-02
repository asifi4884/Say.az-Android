package com.niyazi.say_az.ui.fragment.reports

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.niyazi.say_az.data.InvoiceData
import com.niyazi.say_az.databinding.ListItemInvoiceBinding
import com.niyazi.say_az.databinding.ListItemReportsBinding

class ReportsViewHolder(private val binding: ListItemReportsBinding) :
    RecyclerView.ViewHolder(binding.root) {

    fun bind(
        item: InvoiceData
    ) {
        binding.apply {

        }
    }

    companion object {
        fun from(parent: ViewGroup): ReportsViewHolder {
            val layoutInflater = LayoutInflater.from(parent.context)
            val binding = ListItemReportsBinding.inflate(layoutInflater, parent, false)
            return ReportsViewHolder(binding)
        }
    }

}