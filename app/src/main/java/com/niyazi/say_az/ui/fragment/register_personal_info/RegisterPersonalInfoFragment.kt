package com.niyazi.say_az.ui.fragment.register_personal_info

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AutoCompleteTextView
import androidx.core.widget.addTextChangedListener
import androidx.navigation.fragment.findNavController
import com.niyazi.say_az.R
import com.niyazi.say_az.databinding.FragmentRegisterBinding
import com.niyazi.say_az.databinding.FragmentRegisterPersonalInfoBinding
import com.niyazi.say_az.utils.extensions.isTextNotEmpty
import com.niyazi.say_az.utils.extensions.setFirstItem


class RegisterPersonalInfoFragment : Fragment() {

    private var _binding: FragmentRegisterPersonalInfoBinding? = null

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentRegisterPersonalInfoBinding.inflate(inflater, container, false)
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
            (binding.textInputLayoutActivityType.editText as? AutoCompleteTextView)?.setFirstItem(
                this,
                resources.getStringArray(R.array.activities_list)
            )
        }
    }

    private fun setOnClickListener() {
        binding.apply {
            buttonRegister.setOnClickListener {
                findNavController().navigate(RegisterPersonalInfoFragmentDirections.actionRegisterPersonalInfoFragmentToCreateAccountFragment())
            }
            textInputLayoutName.editText?.addTextChangedListener {
                textInputLayoutName.isTextNotEmpty()
            }

            textInputLayoutSurname.editText?.addTextChangedListener {
                textInputLayoutSurname.isTextNotEmpty()
            }

            textInputLayoutFin.editText?.addTextChangedListener {
                textInputLayoutFin.isTextNotEmpty()
            }
        }
    }

}