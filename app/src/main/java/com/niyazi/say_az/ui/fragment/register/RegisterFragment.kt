package com.niyazi.say_az.ui.fragment.register

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.widget.addTextChangedListener
import androidx.navigation.fragment.findNavController
import com.niyazi.say_az.R
import com.niyazi.say_az.databinding.FragmentMainLoginBinding
import com.niyazi.say_az.databinding.FragmentRegisterBinding
import com.niyazi.say_az.utils.extensions.isPhoneNumber


class RegisterFragment : Fragment() {

    private var _binding: FragmentRegisterBinding? = null

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentRegisterBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.textInputLayoutAsanNumber.isPhoneNumber(false)
        setOnClickListener()
    }

    private fun setOnClickListener() {
        binding.apply {
            buttonNext.setOnClickListener {
                findNavController().navigate(RegisterFragmentDirections.actionRegisterFragmentToRegisterPersonalInfoFragment())
            }
            var previousPhone = textInputLayoutAsanNumber.editText?.text.toString()
            textInputLayoutAsanNumber.editText?.addTextChangedListener {
                textInputLayoutAsanNumber.isPhoneNumber(it.toString().length < previousPhone.length)
                previousPhone = it.toString()
            }
        }
    }

}