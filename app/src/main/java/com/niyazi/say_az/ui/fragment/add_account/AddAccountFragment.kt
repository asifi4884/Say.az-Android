package com.niyazi.say_az.ui.fragment.add_account

import android.os.Bundle
import android.text.Editable
import android.text.InputFilter
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.widget.addTextChangedListener
import androidx.core.widget.doAfterTextChanged
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.niyazi.say_az.R
import com.niyazi.say_az.databinding.FragmentAddAccountBinding
import com.niyazi.say_az.utils.CARD_NUMBER
import com.niyazi.say_az.utils.NON_DIGIT
import com.niyazi.say_az.utils.extensions.withoutWhitespace


class AddAccountFragment : Fragment() {

    private var _binding: FragmentAddAccountBinding? = null

    private val binding get() = _binding!!

    private var current = ""

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentAddAccountBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setOnClickListener()
        observeValue()
    }

    private fun observeValue() {
        binding.apply {
            textInputLayoutCardNumber.editText?.doAfterTextChanged {
                addSpaceToCardNumber(it)
                isValidCardNumber()
            }

            textInputLayoutCvc.editText?.addTextChangedListener {
                isValidCVC()
            }

            textInputLayoutCardEndDate.editText?.doAfterTextChanged {
                addLineToDate(it)
                isValidDate()
            }
        }
    }

    private fun setOnClickListener() {
        binding.buttonAdd.setOnClickListener {
            if (isValidCardNumber() && isValidCVC() && isValidDate()) {
                findNavController().previousBackStackEntry?.savedStateHandle?.set(
                    CARD_NUMBER,
                    binding.textInputLayoutCardNumber.editText?.text.toString()
                )
                findNavController().popBackStack()
            }
        }
    }

    private fun isValidCardNumber(): Boolean {
        binding.textInputLayoutCardNumber.apply {
            if (editText?.text.toString().withoutWhitespace.length == 16) {
                isErrorEnabled = false
                return true
            }
            isErrorEnabled = true
            error = context?.getString(R.string.error_card_number)
        }
        return false
    }

    private fun isValidCVC(): Boolean {
        binding.textInputLayoutCvc.apply {
            if (editText?.text.toString().length == 3) {
                isErrorEnabled = false
                return true
            }
            isErrorEnabled = true
            error = context?.getString(R.string.error_cvc)
        }
        return false
    }

    private fun isValidDate(): Boolean {
        binding.textInputLayoutCardEndDate.apply {
            if (editText?.text.toString().length == 5) {
                isErrorEnabled = false
                return true
            }
            isErrorEnabled = true
            error = context?.getString(R.string.error_cvc)
        }
        return false
    }

    private fun addSpaceToCardNumber(it: Editable?) {
        if (it.toString() != current) {
            val userInput = it.toString().replace(NON_DIGIT, "")
            if (userInput.length <= 16) {
                current = userInput.chunked(4).joinToString(" ")
                it?.filters = arrayOfNulls<InputFilter>(0)
            }
            it?.replace(0, it.length, current, 0, current.length)
        }
    }

    private fun addLineToDate(editable: Editable?) {
        if (editable.toString() != current) {
            val userInput = editable.toString().replace(NON_DIGIT, "")
            if (userInput.length <= 4) {
                current = userInput.chunked(2).joinToString("/")
                editable?.filters = arrayOfNulls<InputFilter>(0)
            }
            editable?.replace(0, editable.length, current, 0, current.length)
        }
    }

}