package com.niyazi.say_az.ui.fragment.intro

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.google.android.material.tabs.TabLayoutMediator
import com.niyazi.say_az.MainNavGraphDirections
import com.niyazi.say_az.R
import com.niyazi.say_az.databinding.FragmentIntroParentBinding


class IntroParentFragment : Fragment() {

    private var _binding: FragmentIntroParentBinding? = null

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentIntroParentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViewPager()
        setOnClickListener()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun initViewPager() {
        binding.viewPagerIntro.adapter = IntroViewPagerAdapter(this)
        TabLayoutMediator(
            binding.tabLayoutIndicator,
            binding.viewPagerIntro
        ) { _, _ ->

        }.attach()

    }

    private fun setOnClickListener() {
        binding.textViewSkip.setOnClickListener {
            findNavController().navigate(MainNavGraphDirections.actionGlobalLoginNavGraph())
        }
        binding.textViewNext.setOnClickListener {
            if (binding.viewPagerIntro.currentItem == binding.viewPagerIntro.adapter?.itemCount?.minus(
                    1
                )
            ) {
                findNavController().navigate(MainNavGraphDirections.actionGlobalLoginNavGraph())
            } else {
                binding.viewPagerIntro.currentItem = binding.viewPagerIntro.currentItem + 1
            }
        }

    }

}