package com.niyazi.say_az.ui.fragment.create_account

import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.niyazi.say_az.data.CreateAccountData
import com.niyazi.say_az.listener.RecyclerViewItemClickListener

/**
 * Created by Niyazi on 12/20/2020.
 */
class CreateAccountAdapter(private val listener: RecyclerViewItemClickListener<CreateAccountData>) :
    ListAdapter<CreateAccountData, CreateAccountViewHolder>(CreateAccountDiffUtil()) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CreateAccountViewHolder {
        return CreateAccountViewHolder.from(parent)
    }

    override fun onBindViewHolder(holder: CreateAccountViewHolder, position: Int) {
        holder.bind(getItem(position), listener)
    }


}