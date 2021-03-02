package com.niyazi.say_az.ui.fragment.splash

import android.os.Bundle
import android.os.CountDownTimer
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.niyazi.say_az.MainNavGraphDirections
import com.niyazi.say_az.databinding.FragmentSplashBinding
import com.niyazi.say_az.manager.PreferenceManager
import com.niyazi.say_az.utils.COUNT_DOWN_INTERVAL
import com.niyazi.say_az.utils.START_UP_TIME

class SplashFragment : Fragment() {

    private var _binding: FragmentSplashBinding? = null

    private val binding get() = _binding!!

    private var timer: CountDownTimer? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentSplashBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        openNextPage()
    }

    override fun onResume() {
        super.onResume()
        timer?.start()
    }

    override fun onPause() {
        super.onPause()
        timer?.cancel()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun openNextPage() {
        timer = object : CountDownTimer(START_UP_TIME, COUNT_DOWN_INTERVAL) {
            override fun onTick(millisUntilFinished: Long) {

            }

            override fun onFinish() {
                context?.let {
                    if (PreferenceManager.getInstance(it).isLogin()) {
                        findNavController().navigate(MainNavGraphDirections.actionGlobalHomeNavGraph())
                    } else {
                        findNavController().navigate(SplashFragmentDirections.actionSplashFragmentToIntroParentFragment())
                    }
                }
            }

        }
    }

}