package com.niyazi.say_az.ui.fragment.percent

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AutoCompleteTextView
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import com.niyazi.say_az.R
import com.niyazi.say_az.databinding.FragmentReportBinding
import com.niyazi.say_az.utils.extensions.setFirstItem


class ReportFragment : Fragment() {

    private var _binding: FragmentReportBinding? = null

    private val binding get() = _binding!!

    private val terms = arrayOf("I", "II", "III", "IV")

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentReportBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initSpinner()
        setOnClickListener()
    }

    private fun initSpinner() {
        context?.apply {

            (binding.textInputLayoutReportType.editText as? AutoCompleteTextView)?.setFirstItem(
                this,
                resources.getStringArray(R.array.report_type_list)
            )

            (binding.textInputLayoutTerm.editText as? AutoCompleteTextView)?.setFirstItem(
                this,
                terms
            )
            setMonth(context?.resources?.getStringArray(R.array.month_I_term))

            (binding.includeUniqueDeclaration.textInputLayoutActivities.editText as? AutoCompleteTextView)?.setFirstItem(
                this,
                resources.getStringArray(R.array.activities_list)
            )

            (binding.textInputLayoutYear.editText as? AutoCompleteTextView)?.setFirstItem(
                this,
               arrayOf("2021","2020","2019","2018","2017","2016")
            )

        }

    }

    private fun setOnClickListener() {
        binding.apply {
            (textInputLayoutReportType.editText as? AutoCompleteTextView)?.setOnItemClickListener { _, _, position, _ ->
                includeTaxReport.root.isVisible = position == 0
                includeUniqueDeclaration.root.isVisible = position == 1
                includeIncomeTaxDeclaration.root.isVisible = position == 2
                textInputLayoutTerm.isVisible = position != 2
            }

            (textInputLayoutTerm.editText as? AutoCompleteTextView)?.setOnItemClickListener { _, _, position, _ ->
                when (position) {
                    0 -> setMonth(context?.resources?.getStringArray(R.array.month_I_term))
                    1 -> setMonth(context?.resources?.getStringArray(R.array.month_II_term))
                    2 -> setMonth(context?.resources?.getStringArray(R.array.month_III_term))
                    3 -> setMonth(context?.resources?.getStringArray(R.array.month_IV_term))
                }
            }

            (includeUniqueDeclaration.textInputLayoutActivities.editText as? AutoCompleteTextView)?.setOnItemClickListener { _, _, position, _ ->
                includeUniqueDeclaration.groupCheckbox.isVisible = position == 1
            }

        }
    }

    private fun setMonth(term: Array<String>?) {
        binding.includeUniqueDeclaration.apply {
            checkBoxFirstMonth.text = term?.get(0) ?: ""
            checkBoxSecondMonth.text = term?.get(1) ?: ""
            checkBoxThirdMonth.text = term?.get(2) ?: ""
        }
    }

}