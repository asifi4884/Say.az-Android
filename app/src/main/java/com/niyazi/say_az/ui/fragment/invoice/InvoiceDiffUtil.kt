package com.niyazi.say_az.ui.fragment.invoice

import androidx.recyclerview.widget.DiffUtil
import com.niyazi.say_az.data.InvoiceData

class InvoiceDiffUtil : DiffUtil.ItemCallback<InvoiceData>() {
    override fun areItemsTheSame(oldItem: InvoiceData, newItem: InvoiceData): Boolean {
        return oldItem.number == newItem.number
    }

    override fun areContentsTheSame(oldItem: InvoiceData, newItem: InvoiceData): Boolean {
        return oldItem == newItem
    }

}