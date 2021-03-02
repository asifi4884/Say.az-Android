package com.niyazi.say_az.ui.fragment.dashboard

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.niyazi.say_az.HomeNavGraphDirections
import com.niyazi.say_az.R
import com.niyazi.say_az.data.DashboardData
import com.niyazi.say_az.databinding.FragmentDashboardBinding
import com.niyazi.say_az.utils.ListDialog


class DashboardFragment : Fragment() {

    private var _binding: FragmentDashboardBinding? = null

    private val binding get() = _binding!!

    private var dashboardAdapter: DashboardAdapter? = null

    private val listOfMonthly = listOf(
        DashboardData("Yanvar", null),
        DashboardData(null, R.drawable.ic_dashboard_placeholder),
        DashboardData(null, R.drawable.ic_dashboard_placeholder),
        DashboardData("Fevral", null),
        DashboardData(null, R.drawable.ic_dashboard_placeholder),
        DashboardData(null, R.drawable.ic_dashboard_placeholder),
        DashboardData("Mart", null),
        DashboardData(null, R.drawable.ic_dashboard_placeholder),
        DashboardData(null, R.drawable.ic_dashboard_placeholder),
        DashboardData("Aprel", null),
        DashboardData(null, R.drawable.ic_dashboard_placeholder),
        DashboardData(null, R.drawable.ic_dashboard_placeholder),
        DashboardData("May", null),
        DashboardData(null, R.drawable.ic_dashboard_placeholder),
        DashboardData(null, R.drawable.ic_dashboard_placeholder)
    )

    private val listOfYearly = listOf(
        DashboardData("2020", null),
        DashboardData(null, R.drawable.ic_dashboard_placeholder_yearly),
        DashboardData(null, R.drawable.ic_dashboard_placeholder_yearly),
        DashboardData("2019", null),
        DashboardData(null, R.drawable.ic_dashboard_placeholder_yearly),
        DashboardData(null, R.drawable.ic_dashboard_placeholder_yearly),
        DashboardData("2018", null),
        DashboardData(null, R.drawable.ic_dashboard_placeholder_yearly),
        DashboardData(null, R.drawable.ic_dashboard_placeholder_yearly),
        DashboardData("2017", null),
        DashboardData(null, R.drawable.ic_dashboard_placeholder_yearly),
        DashboardData(null, R.drawable.ic_dashboard_placeholder_yearly),
        DashboardData("2016", null),
        DashboardData(null, R.drawable.ic_dashboard_placeholder_yearly),
        DashboardData(null, R.drawable.ic_dashboard_placeholder_yearly),
        DashboardData("2015", null),
        DashboardData(null, R.drawable.ic_dashboard_placeholder_yearly),
        DashboardData(null, R.drawable.ic_dashboard_placeholder_yearly),
        DashboardData("2014", null),
        DashboardData(null, R.drawable.ic_dashboard_placeholder_yearly),
        DashboardData(null, R.drawable.ic_dashboard_placeholder_yearly),
        DashboardData("2013", null),
        DashboardData(null, R.drawable.ic_dashboard_placeholder_yearly),
        DashboardData(null, R.drawable.ic_dashboard_placeholder_yearly),
        DashboardData("2012", null),
        DashboardData(null, R.drawable.ic_dashboard_placeholder_yearly),
        DashboardData(null, R.drawable.ic_dashboard_placeholder_yearly),
        DashboardData("2011", null),
        DashboardData(null, R.drawable.ic_dashboard_placeholder_yearly),
        DashboardData(null, R.drawable.ic_dashboard_placeholder_yearly),
        DashboardData("2010", null),
        DashboardData(null, R.drawable.ic_dashboard_placeholder_yearly),
        DashboardData(null, R.drawable.ic_dashboard_placeholder_yearly)
    )

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentDashboardBinding.inflate(inflater, container, false)
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
        dashboardAdapter = DashboardAdapter()
        binding.recyclerViewDashboard.adapter = dashboardAdapter
        dashboardAdapter?.submitList(listOfYearly)
    }

    private fun setOnClickListener() {
        binding.apply {
            textViewYearly.setOnClickListener {
                context?.let {
                    findNavController().navigate(
                        HomeNavGraphDirections.actionGlobalChoiceFragment(
                            ListDialog.TERM,
                            it.resources.getStringArray(R.array.term_list),
                            textViewYearly.text.toString()
                        )
                    )
                }
            }
        }
    }

    private fun observeValue() {
        findNavController().currentBackStackEntry?.savedStateHandle?.getLiveData<String>(ListDialog.TERM.name)
            ?.observe(viewLifecycleOwner) {
                context?.let { context ->
                    binding.textViewYearly.text = it
                    dashboardAdapter?.submitList(
                        if (it == context.getString(R.string.msg_monthly)) {
                            listOfMonthly
                        } else listOfYearly
                    )
                }
            }
    }
}