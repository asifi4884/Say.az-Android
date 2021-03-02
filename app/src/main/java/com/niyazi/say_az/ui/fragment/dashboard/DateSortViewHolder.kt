package com.niyazi.say_az.ui.fragment.dashboard

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.niyazi.say_az.databinding.ListItemDateSortBinding
import com.niyazi.say_az.listener.RecyclerViewItemClickListener

/**
 * Created by Niyazi on 12/27/2020.
 */
class DateSortViewHolder(private val binding: ListItemDateSortBinding) :
    RecyclerView.ViewHolder(binding.root) {

    fun bind(item: String?
    ) {
        binding.apply {
            textViewTitle.text = item
        }
    }

    companion object {
        fun from(parent: ViewGroup): DateSortViewHolder {
            val layoutInflater = LayoutInflater.from(parent.context)
            val binding = ListItemDateSortBinding.inflate(layoutInflater, parent, false)
            return DateSortViewHolder(binding)
        }
    }

}