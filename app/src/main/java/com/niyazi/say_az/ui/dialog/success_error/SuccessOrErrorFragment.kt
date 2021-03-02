package com.niyazi.say_az.ui.dialog.success_error

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.niyazi.say_az.R
import com.niyazi.say_az.databinding.FragmentSuccessOrErrorBinding
import com.niyazi.say_az.listener.DialogListener
import com.niyazi.say_az.utils.DialogDesign


class SuccessOrErrorFragment : BottomSheetDialogFragment() {

    private var _binding: FragmentSuccessOrErrorBinding? = null

    private val binding get() = _binding!!
    private var dialogListener: DialogListener? = null
    private val args by navArgs<SuccessOrErrorFragmentArgs>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setStyle(STYLE_NO_TITLE, R.style.FullScreenDialogStyleSettingsDialog)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentSuccessOrErrorBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        dialogListener = parentFragmentManager.fragments[0] as? DialogListener
    }

    override fun onDetach() {
        super.onDetach()
        dialogListener = null
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setDesign()
        setOnClickListener()
    }

    private fun setOnClickListener() {
        binding.imageViewExit.setOnClickListener { dismiss() }
        binding.textViewOk.setOnClickListener {
            findNavController().popBackStack()
            when (args.dialogType) {
                DialogDesign.ERROR -> {
                    dialogListener?.onClickError()
                }
                DialogDesign.SUCCESS -> {
                    dialogListener?.onClickSuccess()
                }
            }
        }
    }

    private fun setDesign() {
        context?.let { context ->
            binding.textViewTitle.text = context.getString(args.dialogType.title)
            binding.textViewBody.text = args.bodyText
            binding.textViewTitle.setTextColor(
                ContextCompat.getColor(
                    context,
                    args.dialogType.color
                )
            )
        }
    }
}