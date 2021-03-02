package com.niyazi.say_az.ui.dialog.choice

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatDelegate
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.niyazi.say_az.R
import com.niyazi.say_az.databinding.FragmentChoiceBinding
import com.niyazi.say_az.manager.PreferenceManager
import com.niyazi.say_az.manager.setNewLocale
import com.niyazi.say_az.ui.activity.MainActivity
import com.niyazi.say_az.utils.Language
import com.niyazi.say_az.utils.ListDialog
import com.niyazi.say_az.utils.SYSTEM_DEFAULT
import com.niyazi.say_az.utils.extensions.setUiMode
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class ChoiceFragment : BottomSheetDialogFragment() {

    private var _binding: FragmentChoiceBinding? = null
    private val args by navArgs<ChoiceFragmentArgs>()

    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setStyle(STYLE_NO_TITLE, R.style.FullScreenDialogStyleSettingsDialog)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentChoiceBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setDefaultValues()
        setOnClickListener()
    }

    private fun setDefaultValues() {
        binding.picker.apply {
            maxValue = args.values.size - 1
            displayedValues = args.values
            value = args.values.indexOf(args.previousValue)
        }
    }

    private fun setOnClickListener() {
        binding.buttonChoose.setOnClickListener {
            when (args.type) {
                ListDialog.LANG -> {
                    changeLang()
                }
                ListDialog.MODE -> {
                    setMode(args.values, binding.picker.value)
                }
                ListDialog.RECEIPTS -> {
                    findNavController().previousBackStackEntry?.savedStateHandle?.set(
                        ListDialog.RECEIPTS.name,
                        resources.getStringArray(R.array.receipts_list)[binding.picker.value]
                    )
                }
                ListDialog.TERM->{
                    findNavController().previousBackStackEntry?.savedStateHandle?.set(
                        ListDialog.TERM.name,
                        resources.getStringArray(R.array.term_list)[binding.picker.value]
                    )
                }
            }
            findNavController().popBackStack()
        }


        binding.textViewCancel.setOnClickListener {
            findNavController().popBackStack()
        }
    }

    private fun changeLang() {
        context?.let {
            when (args.values[binding.picker.value]) {
                it.getString(R.string.msg_az_lang) -> {
                    PreferenceManager.getInstance(it).setLang(Language.LANG_AZ)
                }
                it.getString(R.string.msg_en_lang) -> {
                    PreferenceManager.getInstance(it).setLang(Language.LANG_EN)
                }
                it.getString(R.string.msg_ru_lang) -> {
                    PreferenceManager.getInstance(it).setLang(Language.LANG_RU)
                }
                else -> {
                }
            }
            it.setNewLocale(PreferenceManager.getInstance(it).getLang())
        }
        val intent = Intent(context, MainActivity::class.java)
        intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
        startActivity(intent)
    }

    private fun setMode(values: Array<String>, indices: Int) {
        context?.let {
            when (values[indices]) {
                it.getString(R.string.msg_mode_default) -> {
                    PreferenceManager.getInstance(it)
                        .setUiMode(SYSTEM_DEFAULT)
                }
                it.getString(R.string.msg_mode_light) -> {
                    PreferenceManager.getInstance(it).setUiMode(AppCompatDelegate.MODE_NIGHT_NO)
                }
                it.getString(R.string.msg_mode_night) -> {
                    PreferenceManager.getInstance(it).setUiMode(AppCompatDelegate.MODE_NIGHT_YES)
                }
            }
            activity?.let { activity ->
                PreferenceManager.getInstance(activity.baseContext).getUiModeOn()
                    .setUiMode(activity.applicationContext)
            }
        }
    }

}