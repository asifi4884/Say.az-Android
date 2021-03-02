package com.niyazi.say_az.ui.fragment.my_bank_accounts

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.niyazi.say_az.data.MyBankAccountsData
import com.niyazi.say_az.databinding.ListItemMyBankAccountsBinding
import com.niyazi.say_az.listener.RecyclerViewItemClickListener

/**
 * Created by Niyazi on 12/27/2020.
 */
class MyBankAccountsViewHolder(private val binding: ListItemMyBankAccountsBinding) :
    RecyclerView.ViewHolder(binding.root) {

    fun bind(
        item: MyBankAccountsData,
        listener: RecyclerViewItemClickListener<MyBankAccountsData>
    ) {
        binding.apply {
            textViewCardNumber.text = item.cardNumber
            imageViewDelete.setOnClickListener {
                listener.onItemDeleteClick(item)
            }
        }
    }

    companion object {
        fun from(parent: ViewGroup): MyBankAccountsViewHolder {
            val layoutInflater = LayoutInflater.from(parent.context)
            val binding = ListItemMyBankAccountsBinding.inflate(layoutInflater, parent, false)
            return MyBankAccountsViewHolder(binding)
        }
    }

}