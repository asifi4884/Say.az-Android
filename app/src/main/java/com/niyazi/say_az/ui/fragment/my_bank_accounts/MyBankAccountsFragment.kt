package com.niyazi.say_az.ui.fragment.my_bank_accounts

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.niyazi.say_az.data.MyBankAccountsData
import com.niyazi.say_az.databinding.FragmentMyBankAccountsBinding
import com.niyazi.say_az.listener.RecyclerViewItemClickListener
import com.niyazi.say_az.manager.PreferenceManager
import com.niyazi.say_az.utils.CARD_NUMBER
import com.niyazi.say_az.utils.Preference
import com.niyazi.say_az.utils.extensions.withoutWhitespace

class MyBankAccountsFragment : Fragment() {

    private var _binding: FragmentMyBankAccountsBinding? = null

    private val binding get() = _binding!!
    private var myBankAccountsAdapter: MyBankAccountsAdapter? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentMyBankAccountsBinding.inflate(inflater, container, false)
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
        myBankAccountsAdapter =
            MyBankAccountsAdapter(RecyclerViewItemClickListener(itemDeleteClickListener = {
                deleteItem(it)
            }))
        binding.recyclerViewMyBankAccounts.adapter = myBankAccountsAdapter
        myBankAccountsAdapter?.submitList(
            PreferenceManager.getInstance(requireContext())
                .getTestAccountsArrayList()
        )
    }

    private fun setOnClickListener() {
        binding.apply {
            buttonAdd.setOnClickListener {
                findNavController().navigate(MyBankAccountsFragmentDirections.actionMyBankAccountsFragmentToAddAccountFragmentMyBankAccounts())
            }
        }
    }

    private fun observeValue() {
        findNavController().currentBackStackEntry?.savedStateHandle?.getLiveData<String>(CARD_NUMBER)
            ?.observe(viewLifecycleOwner) {
                val listOfAccounts = PreferenceManager.getInstance(requireContext()).getTestAccountsArrayList() ?: arrayListOf()
                val cardNumber = it.withoutWhitespace
                val lastFourDigit = cardNumber.removeRange(0, cardNumber.length - 4)
                listOfAccounts.add(MyBankAccountsData("**** **** **** $lastFourDigit"))
                PreferenceManager.getInstance(requireContext())
                    .setTestAccountsArrayList(listOfAccounts)
                myBankAccountsAdapter?.submitList(listOfAccounts)
                myBankAccountsAdapter?.notifyDataSetChanged()
            }
    }

    private fun deleteItem(item: MyBankAccountsData) {
        val listOfAccounts = PreferenceManager.getInstance(requireContext())
            .getTestAccountsArrayList()
        listOfAccounts?.remove(item)
        PreferenceManager.getInstance(requireContext()).setTestAccountsArrayList(listOfAccounts)
        myBankAccountsAdapter?.submitList(listOfAccounts?.map { it?.copy() })
        myBankAccountsAdapter?.notifyDataSetChanged()
    }
}