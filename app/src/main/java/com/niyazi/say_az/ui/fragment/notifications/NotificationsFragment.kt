package com.niyazi.say_az.ui.fragment.notifications

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.niyazi.say_az.R
import com.niyazi.say_az.data.NotificationData
import com.niyazi.say_az.databinding.FragmentLoginBinding
import com.niyazi.say_az.databinding.FragmentNotificationsBinding


class NotificationsFragment : Fragment() {

    private var _binding: FragmentNotificationsBinding? = null

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentNotificationsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initRecyclerView()
    }

    private fun initRecyclerView() {
        val adapter = NotificationAdapter()
        binding.recyclerViewNotification.adapter = adapter
        adapter.submitList(
            listOf(
                NotificationData(status = true, 1),
                NotificationData(status = true, 2),
                NotificationData(status = true, 3),
                NotificationData(status = false, 4),
                NotificationData(status = false, 5),
                NotificationData(status = true, 6),
                NotificationData(status = true, 6),
                NotificationData(status = true, 8)
            )
        )
    }

}