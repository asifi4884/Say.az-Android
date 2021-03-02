package com.niyazi.say_az.ui.fragment.invoice

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.niyazi.say_az.data.InvoiceData
import com.niyazi.say_az.databinding.ListItemInvoiceBinding

class InvoiceViewHolder(private val binding: ListItemInvoiceBinding) :
    RecyclerView.ViewHolder(binding.root) {

    fun bind(
        item: InvoiceData
    ) {
        binding.apply {

        }
    }

    companion object {
        fun from(parent: ViewGroup): InvoiceViewHolder {
            val layoutInflater = LayoutInflater.from(parent.context)
            val binding = ListItemInvoiceBinding.inflate(layoutInflater, parent, false)
            return InvoiceViewHolder(binding)
        }
    }

}