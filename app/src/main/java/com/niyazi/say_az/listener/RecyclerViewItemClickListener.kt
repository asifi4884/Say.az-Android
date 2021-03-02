package com.niyazi.say_az.listener

/**
 * Created by Niyazi on 12/20/2020.
 */
class RecyclerViewItemClickListener<T>(
    private val itemClickListener: (data: T) -> Unit = {},
    private val itemDeleteClickListener: (data: T) -> Unit = {}
) {
    fun onItemClick(data: T) = itemClickListener(data)
    fun onItemDeleteClick(data: T) = itemDeleteClickListener(data)
}