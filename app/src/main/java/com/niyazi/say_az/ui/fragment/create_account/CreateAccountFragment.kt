package com.niyazi.say_az.ui.fragment.create_account

import android.content.res.ColorStateList
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import androidx.core.content.ContextCompat
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.niyazi.say_az.MainNavGraphDirections
import com.niyazi.say_az.R
import com.niyazi.say_az.data.CreateAccountData
import com.niyazi.say_az.databinding.FragmentCreateAccountBinding
import com.niyazi.say_az.listener.DialogListener
import com.niyazi.say_az.listener.RecyclerViewItemClickListener
import com.niyazi.say_az.manager.PreferenceManager
import com.niyazi.say_az.utils.DialogDesign
import com.niyazi.say_az.utils.extensions.setFirstItem


class CreateAccountFragment : Fragment(), DialogListener {

    private var _binding: FragmentCreateAccountBinding? = null

    private val binding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentCreateAccountBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initRecyclerView()
        initSpinner()
        setOnClickListener()
    }

    override fun onClickSuccess() {
        findNavController().navigate(MainNavGraphDirections.actionGlobalHomeNavGraph())
        context?.let { PreferenceManager.getInstance(it).setLogin(true) }
    }

    private fun initSpinner() {
        val adapter = context?.let { context ->
            ArrayAdapter(
                context,
                android.R.layout.simple_list_item_1,
                listOf("Kapital bank")
            )
        }
        (binding.textInputLayoutBank.editText as? AutoCompleteTextView)?.setAdapter(adapter)
    }

    private fun initRecyclerView() {
        val adapter = CreateAccountAdapter(RecyclerViewItemClickListener(itemClickListener = {}))
        adapter.submitList(
            listOf(
                CreateAccountData(
                    R.drawable.ic_card_placeholder_visa,
                    "Visa Electron",
                    "İllik xidmət haqqı: 8 AZN"
                ),
                CreateAccountData(
                    R.drawable.ic_card_placeholder_maestro,
                    "Maestro",
                    "İllik xidmət haqqı: 8 AZN"
                ),
                CreateAccountData(
                    R.drawable.ic_card_placeholder_visa_classic,
                    "Visa Classic",
                    "İllik xidmət haqqı: 8 AZN"
                )
            )
        )
        binding.recyclerViewBank.adapter = adapter
    }

    private fun setOnClickListener() {
        (binding.textInputLayoutBank.editText as? AutoCompleteTextView)?.setOnItemClickListener { _, _, position, _ ->
            binding.recyclerViewBank.isVisible = true
            context?.let {
                binding.buttonSend.backgroundTintList =
                    ColorStateList.valueOf(ContextCompat.getColor(it, R.color.colorTeal))
                binding.buttonSend.setTextColor(ContextCompat.getColor(it, R.color.colorWhite))
            }
        }
        binding.buttonSend.setOnClickListener {
            findNavController().navigate(
                MainNavGraphDirections.actionGlobalSuccessOrErrorFragment2(
                    dialogType = DialogDesign.SUCCESS,
                    bodyText = "Lorem ipsum dolor sit amet, consectetur adipiscing elit."
                )
            )
        }
    }

}