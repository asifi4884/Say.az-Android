package com.niyazi.say_az.ui.fragment.create_account

import androidx.recyclerview.widget.DiffUtil
import com.niyazi.say_az.data.CreateAccountData

/**
 * Created by Niyazi on 12/20/2020.
 */
class CreateAccountDiffUtil : DiffUtil.ItemCallback<CreateAccountData>() {
    override fun areItemsTheSame(oldItem: CreateAccountData, newItem: CreateAccountData): Boolean {
        return oldItem.imagePath== newItem.imagePath
    }

    override fun areContentsTheSame(oldItem: CreateAccountData, newItem: CreateAccountData): Boolean {
        return oldItem == newItem
    }

}