package com.niyazi.say_az.ui.fragment.settings

import android.content.ActivityNotFoundException
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatDelegate
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.niyazi.say_az.HomeNavGraphDirections
import com.niyazi.say_az.MainNavGraphDirections
import com.niyazi.say_az.R
import com.niyazi.say_az.databinding.FragmentSettingsBinding
import com.niyazi.say_az.manager.PreferenceManager
import com.niyazi.say_az.ui.activity.MainActivity
import com.niyazi.say_az.utils.DialogDesign
import com.niyazi.say_az.utils.Language
import com.niyazi.say_az.utils.ListDialog
import com.niyazi.say_az.utils.TAX_MINISTRY_MAIL


class SettingsFragment : Fragment() {

    private var _binding: FragmentSettingsBinding? = null

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentSettingsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setLanguage()
        setUiMode()
        setOnClickListener()
    }

    private fun setOnClickListener() {
        binding.textViewShadowLanguage.setOnClickListener {
            context?.let {
                findNavController().navigate(
                    HomeNavGraphDirections.actionGlobalChoiceFragment(
                        ListDialog.LANG,
                        it.resources.getStringArray(
                            R.array.language_list
                        ),
                        binding.textViewShadowLanguage.getEndText()
                    )
                )
            }
        }
        binding.textViewShadowMode.setOnClickListener {
            context?.let {
                findNavController().navigate(
                    HomeNavGraphDirections.actionGlobalChoiceFragment(
                        ListDialog.MODE,
                        it.resources.getStringArray(
                            R.array.mode_list
                        ),
                        binding.textViewShadowMode.getEndText()
                    )
                )
            }
        }

        binding.textViewShadowDelete.setOnClickListener {

        }

        binding.textViewShadowBankAccount.setOnClickListener {
            findNavController().navigate(SettingsFragmentDirections.actionSettingsFragmentToMyBankAccountsFragment())
        }

        binding.textViewShadowInfoAboutApp.setOnClickListener {
            findNavController().navigate(SettingsFragmentDirections.actionSettingsFragmentToInfoAboutAppFragment())
        }

        binding.textViewShadowBankSendMail.setOnClickListener {
            composeEmail(arrayOf(TAX_MINISTRY_MAIL), getString(R.string.app_name))
        }

        binding.textViewShadowLogout.setOnClickListener {
            context?.let { it1 -> PreferenceManager.getInstance(it1).setLogin(false) }
            findNavController().navigate(MainNavGraphDirections.actionGlobalLoginNavGraph())
        }
    }

    private fun setLanguage() {
        context?.let {
            when (PreferenceManager.getInstance(it).getLang()) {
                Language.LANG_EN -> {
                    binding.textViewShadowLanguage.changeEndText(it.getString(R.string.msg_en_lang))
                }
                Language.LANG_RU -> {
                    binding.textViewShadowLanguage.changeEndText(it.getString(R.string.msg_ru_lang))
                }
                else -> {
                    binding.textViewShadowLanguage.changeEndText(it.getString(R.string.msg_az_lang))
                }
            }
        }
    }

    private fun setUiMode() {
        context?.let {
            when (PreferenceManager.getInstance(it).getUiModeOn()) {
                AppCompatDelegate.MODE_NIGHT_YES -> {
                    binding.textViewShadowMode.changeEndText(it.getString(R.string.msg_mode_night))
                }
                AppCompatDelegate.MODE_NIGHT_NO -> {
                    binding.textViewShadowMode.changeEndText(it.getString(R.string.msg_mode_light))
                }
                else -> {
                    binding.textViewShadowMode.changeEndText(it.getString(R.string.msg_mode_default))
                }
            }
        }
    }

    private fun composeEmail(addresses: Array<String>, subject: String?) {
        activity?.apply {
            val intent = Intent(Intent.ACTION_SENDTO)
            intent.data = Uri.parse("mailto:") // only email apps should handle this
            intent.putExtra(Intent.EXTRA_EMAIL, addresses)
            intent.putExtra(Intent.EXTRA_SUBJECT, subject)
            try {
                startActivity(intent)
            } catch (e: ActivityNotFoundException) {
                findNavController().navigate(
                    MainNavGraphDirections.actionGlobalSuccessOrErrorFragment2(
                      context?.getString(R.string.msg_no_application) ?: "",
                        DialogDesign.ERROR
                    )
                )
            }
        }
    }

}