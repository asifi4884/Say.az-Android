package com.niyazi.say_az.ui.fragment.create_account

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.niyazi.say_az.data.CreateAccountData
import com.niyazi.say_az.databinding.ListItemBankCardBinding
import com.niyazi.say_az.listener.RecyclerViewItemClickListener

/**
 * Created by Niyazi on 12/20/2020.
 */
class CreateAccountViewHolder(private val binding: ListItemBankCardBinding) :
    RecyclerView.ViewHolder(binding.root) {

    fun bind(
        item: CreateAccountData,
        recyclerViewItemClickListener: RecyclerViewItemClickListener<CreateAccountData>
    ) {
        binding.apply {
            item.imagePath?.let { imageViewCard.setImageResource(it) }
            textViewCardType.text = item.type
            textViewAccountValue.text = item.accountValue
        }
        itemView.setOnClickListener {
            recyclerViewItemClickListener.onItemClick(item)
        }
    }

    companion object {
        fun from(parent: ViewGroup): CreateAccountViewHolder {
            val layoutInflater = LayoutInflater.from(parent.context)
            val binding = ListItemBankCardBinding.inflate(layoutInflater, parent, false)
            return CreateAccountViewHolder(binding)
        }
    }

}