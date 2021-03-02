package com.niyazi.say_az.utils.extensions

import android.text.InputFilter
import com.google.android.material.textfield.TextInputLayout
import com.niyazi.say_az.R
import timber.log.Timber


fun TextInputLayout.isTextNotEmpty(): Boolean {
    val matcher = !this.editText?.text.isNullOrEmpty()
    isErrorEnabled = !matcher
    if (!matcher) error = context.getString(R.string.error_empty_field)
    return matcher
}

fun TextInputLayout.isPhoneNumber(isDelete: Boolean): Boolean {
    val countryCode = "+994 "
    val phoneNumberFormat = countryCode + "00 000 00 00"
    editText?.apply {
        filters = arrayOf(InputFilter.LengthFilter(phoneNumberFormat.length))
        if (text.toString().length < countryCode.length) {
            setText(countryCode)
            setSelection(text.toString().length)
        }

        if (!isDelete &&
            text.toString().length > countryCode.length &&
            phoneNumberFormat.length > text.toString().length &&
            phoneNumberFormat[text.toString().length].toString().isBlank()
        ) {
            setText("$text ")
            setSelection(text.toString().length)
        }
    }
    val matcher = !this.editText?.text.isNullOrEmpty()
    isErrorEnabled = !matcher
    if (!matcher) error = context.getString(R.string.error_empty_field)
    return matcher
}