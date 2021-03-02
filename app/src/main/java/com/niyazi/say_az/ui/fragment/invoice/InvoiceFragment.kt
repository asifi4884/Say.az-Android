package com.niyazi.say_az.ui.fragment.invoice

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.niyazi.say_az.HomeNavGraphDirections
import com.niyazi.say_az.R
import com.niyazi.say_az.data.InvoiceData
import com.niyazi.say_az.databinding.FragmentInvoiceBinding
import com.niyazi.say_az.utils.ListDialog


class InvoiceFragment : Fragment() {

    private var _binding: FragmentInvoiceBinding? = null

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentInvoiceBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initRecyclerView()
        setOnClickListener()
        observeValue()
    }

    private fun initRecyclerView() {
        val adapter = InvoiceAdapter()
        binding.recyclerViewInvoice.adapter = adapter
        adapter.submitList(
            listOf(
                InvoiceData(number = null, name = "", worth = "", date = "", year = "2020"),
                InvoiceData(number = "32", name = "", worth = "", date = "", year = null),
                InvoiceData(number = "32", name = "", worth = "", date = "", year = null),
                InvoiceData(number = null, name = "", worth = "", date = "", year = "2019"),
                InvoiceData(number = "32", name = "", worth = "", date = "", year = null),
                InvoiceData(number = "32", name = "", worth = "", date = "", year = null),
                InvoiceData(number = null, name = "", worth = "", date = "", year = "2018"),
                InvoiceData(number = "32", name = "", worth = "", date = "", year = null),
            )
        )
    }

    private fun setOnClickListener() {
        binding.apply {
            textViewReceiptsType.setOnClickListener {
                context?.let { context ->
                    findNavController().navigate(
                        HomeNavGraphDirections.actionGlobalChoiceFragment(
                            ListDialog.RECEIPTS,
                            context.resources.getStringArray(R.array.receipts_list),
                            binding.textViewReceiptsType.text.toString()
                        )
                    )
                }
            }

            floatingActionButtonPlus.setOnClickListener {
                findNavController().navigate(InvoiceFragmentDirections.actionInvoiceFragmentToSendInvoiceFragment())
            }
        }
    }

    private fun observeValue() {
        findNavController().currentBackStackEntry?.savedStateHandle?.getLiveData<String>(ListDialog.RECEIPTS.name)
            ?.observe(viewLifecycleOwner) {
                context?.let { context ->
                    binding.textViewReceiptsType.text = it
                    binding.floatingActionButtonPlus.isVisible =
                        it == context.resources.getString(R.string.msg_receipts_send_by_me)
                }
            }
    }

}