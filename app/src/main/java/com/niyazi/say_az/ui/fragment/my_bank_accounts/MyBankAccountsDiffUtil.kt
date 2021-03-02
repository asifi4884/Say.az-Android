package com.niyazi.say_az.ui.fragment.my_bank_accounts

import androidx.recyclerview.widget.DiffUtil
import com.niyazi.say_az.data.MyBankAccountsData

class MyBankAccountsDiffUtil : DiffUtil.ItemCallback<MyBankAccountsData>() {
    override fun areItemsTheSame(
        oldItem: MyBankAccountsData,
        newItem: MyBankAccountsData
    ): Boolean {
        return oldItem.cardNumber == newItem.cardNumber
    }

    override fun areContentsTheSame(
        oldItem: MyBankAccountsData,
        newItem: MyBankAccountsData
    ): Boolean {
        return oldItem == newItem
    }

}