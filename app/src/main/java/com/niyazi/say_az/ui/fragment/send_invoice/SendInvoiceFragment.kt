package com.niyazi.say_az.ui.fragment.send_invoice

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import com.niyazi.say_az.R
import com.niyazi.say_az.databinding.FragmentSendInvoiceBinding
import com.niyazi.say_az.utils.extensions.setFirstItem
import timber.log.Timber


class SendInvoiceFragment : Fragment() {

    private var _binding: FragmentSendInvoiceBinding? = null

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentSendInvoiceBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initSpinner()
        setOnClickListener()
    }

    private fun initSpinner() {
        context?.apply {
            (binding.textInputLayoutInvoiceType.editText as? AutoCompleteTextView)?.setFirstItem(
                this,
                resources.getStringArray(R.array.voen_list)
            )

            (binding.textInputLayoutPeriod.editText as? AutoCompleteTextView)?.setFirstItem(
                this,
                arrayOf("Period 1", "Period 2", "Period 3", "Period 4")
            )
        }
    }

    private fun setOnClickListener() {
        binding.apply {
            (textInputLayoutInvoiceType.editText as? AutoCompleteTextView)?.setOnItemClickListener { _, _, position, _ ->
                includeVoen.root.isVisible = position == 0
                includeWithoutVoen.root.isVisible = position != 0
            }
        }

    }

}