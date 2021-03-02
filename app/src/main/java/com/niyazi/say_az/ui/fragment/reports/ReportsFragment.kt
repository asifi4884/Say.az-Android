package com.niyazi.say_az.ui.fragment.reports

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.niyazi.say_az.HomeNavGraphDirections
import com.niyazi.say_az.R
import com.niyazi.say_az.data.InvoiceData
import com.niyazi.say_az.databinding.FragmentReportsBinding
import com.niyazi.say_az.utils.ListDialog

class ReportsFragment : Fragment() {

    private var _binding: FragmentReportsBinding? = null

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentReportsBinding.inflate(inflater, container, false)
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
        val adapter = ReportsAdapter()
        binding.recyclerViewReports.adapter = adapter
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
            textViewYearly.setOnClickListener {
                context?.let { context ->
                    findNavController().navigate(
                        HomeNavGraphDirections.actionGlobalChoiceFragment(
                            ListDialog.TERM,
                            context.resources.getStringArray(R.array.term_list),
                            binding.textViewYearly.text.toString()
                        )
                    )
                }
            }

            floatingActionButtonPlus.setOnClickListener {
                findNavController().navigate(ReportsFragmentDirections.actionReportsFragmentToPercentFragment())
            }
        }
    }

    private fun observeValue() {
        findNavController().currentBackStackEntry?.savedStateHandle?.getLiveData<String>(ListDialog.TERM.name)
            ?.observe(viewLifecycleOwner) {
                binding.textViewYearly.text = it
            }
    }

}