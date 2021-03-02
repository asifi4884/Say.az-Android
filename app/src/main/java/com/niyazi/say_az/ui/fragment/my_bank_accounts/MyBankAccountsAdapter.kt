package com.niyazi.say_az.ui.fragment.my_bank_accounts

import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.niyazi.say_az.data.MyBankAccountsData
import com.niyazi.say_az.listener.RecyclerViewItemClickListener

class MyBankAccountsAdapter(private val listener: RecyclerViewItemClickListener<MyBankAccountsData>) :
    ListAdapter<MyBankAccountsData, MyBankAccountsViewHolder>(MyBankAccountsDiffUtil()) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyBankAccountsViewHolder {
        return MyBankAccountsViewHolder.from(parent)
    }

    override fun onBindViewHolder(holder: MyBankAccountsViewHolder, position: Int) {
        holder.bind(getItem(position), listener)
    }


}