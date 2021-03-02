package com.niyazi.say_az.ui.fragment.login_main

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.niyazi.say_az.R
import com.niyazi.say_az.databinding.FragmentMainLoginBinding
import com.niyazi.say_az.databinding.FragmentSplashBinding


class MainLoginFragment : Fragment() {

    private var _binding: FragmentMainLoginBinding? = null

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentMainLoginBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setOnClickListener()
    }

    private fun setOnClickListener() {
        binding.buttonAsanPass.setOnClickListener {
            findNavController().navigate(MainLoginFragmentDirections.actionMainLoginFragmentToLoginFragment())
        }

        binding.textViewRegister.setOnClickListener {
            findNavController().navigate(MainLoginFragmentDirections.actionMainLoginFragmentToRegisterNavGraph())
        }
        binding.textViewAsanLogin.setOnClickListener {

        }
    }
}