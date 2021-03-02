package com.niyazi.say_az.ui.fragment.login

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.widget.addTextChangedListener
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.niyazi.say_az.MainNavGraphDirections
import com.niyazi.say_az.databinding.FragmentLoginBinding
import com.niyazi.say_az.manager.PreferenceManager
import com.niyazi.say_az.utils.extensions.isPhoneNumber
import com.niyazi.say_az.utils.extensions.isTextNotEmpty
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LoginFragment : Fragment() {

    private var _binding: FragmentLoginBinding? = null

    private val binding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentLoginBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.textInputLayoutPhone.isPhoneNumber(false)
        setOnClickListener()
    }

    private fun setOnClickListener() {
        binding.buttonEnter.setOnClickListener {
            context?.let { context ->
                PreferenceManager.getInstance(context).setLogin(true)
                findNavController().navigate(MainNavGraphDirections.actionGlobalHomeNavGraph())
//                if (binding.textInputLayoutPhone.editText?.text ?: "" == "+994 50 222 22 22" &&
//                    binding.textInputLayoutUserId.editText?.text ?: "" == "123456"
//                ) {
//                    PreferenceManager.getInstance(context).setLogin(true)
//                    findNavController().navigate(MainNavGraphDirections.actionGlobalHomeNavGraph())
//                } else {
//                    findNavController().navigate(
//                        MainNavGraphDirections.actionGlobalSuccessOrErrorFragment2(
//                            context.getString(R.string.error_user_credential),
//                            DialogDesign.ERROR
//                        )
//                    )
//                }
            }
        }

        binding.apply {
            var previousPhone = textInputLayoutPhone.editText?.text.toString()
            textInputLayoutPhone.editText?.addTextChangedListener {

                textInputLayoutPhone.isPhoneNumber(it.toString().length < previousPhone.length)
                previousPhone = textInputLayoutPhone.editText?.text.toString()
            }

            textInputLayoutUserId.editText?.addTextChangedListener {
                textInputLayoutUserId.isTextNotEmpty()
            }
        }
    }
}