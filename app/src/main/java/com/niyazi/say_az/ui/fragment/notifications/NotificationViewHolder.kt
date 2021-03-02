package com.niyazi.say_az.ui.fragment.notifications

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.niyazi.say_az.R
import com.niyazi.say_az.data.NotificationData
import com.niyazi.say_az.databinding.ListItemNotificationBinding

/**
 * Created by Niyazi on 12/27/2020.
 */
class NotificationViewHolder(private val binding: ListItemNotificationBinding) :
    RecyclerView.ViewHolder(binding.root) {

    fun bind(
        item: NotificationData
    ) {
        binding.apply {
            if (!item.status) {
                imageViewStatus.setImageResource(R.drawable.ic_exclamation_mark)
                imageViewStatus.setBackgroundColor(
                    ContextCompat.getColor(
                        itemView.context,
                        R.color.colorRed
                    )
                )
            } else {
                imageViewStatus.setImageResource(R.drawable.ic_download_balance)
                imageViewStatus.setBackgroundColor(
                    ContextCompat.getColor(
                        itemView.context,
                        R.color.colorGreen
                    )
                )
            }
        }
    }

    companion object {
        fun from(parent: ViewGroup): NotificationViewHolder {
            val layoutInflater = LayoutInflater.from(parent.context)
            val binding = ListItemNotificationBinding.inflate(layoutInflater, parent, false)
            return NotificationViewHolder(binding)
        }
    }

}