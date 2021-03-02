package com.niyazi.say_az.ui.fragment.intro

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.niyazi.say_az.databinding.FragmentIntroChildBinding
import com.niyazi.say_az.utils.INTRO_BODY
import com.niyazi.say_az.utils.INTRO_IMG
import com.niyazi.say_az.utils.INTRO_TITLE_ID

class IntroChildFragment : Fragment() {

    private var _binding: FragmentIntroChildBinding? = null

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentIntroChildBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        arguments?.let {
            context?.let { context ->
                binding.imageView.setImageResource(it[INTRO_IMG] as Int)
                binding.textViewTitle.text = context.getString(it[INTRO_TITLE_ID] as Int)
                binding.textViewBody.text = it[INTRO_BODY] as String
            }
        }
    }

}