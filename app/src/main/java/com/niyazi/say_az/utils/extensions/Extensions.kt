package com.niyazi.say_az.utils.extensions


import android.content.Context
import android.content.res.Configuration
import android.content.res.Resources
import android.util.TypedValue
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import androidx.appcompat.app.AppCompatDelegate
import com.niyazi.say_az.utils.SYSTEM_DEFAULT

/**
 * Created by Niyazi on 12/23/2020.
 */
fun Context.isDarkModeOn(): Boolean {
    val currentNightMode = resources.configuration.uiMode and Configuration.UI_MODE_NIGHT_MASK
    return currentNightMode == Configuration.UI_MODE_NIGHT_YES
}

fun Resources.convertDpToPx(value: Float) = TypedValue.applyDimension(
    TypedValue.COMPLEX_UNIT_DIP,
    value,
    this.displayMetrics
)

fun Int.setUiMode(context: Context) {
    when (this) {
        AppCompatDelegate.MODE_NIGHT_YES -> {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
        }
        AppCompatDelegate.MODE_NIGHT_NO -> {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
        }
        SYSTEM_DEFAULT -> {
            if (context.isDarkModeOn()) {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
            } else {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
            }
        }
    }
}

fun AutoCompleteTextView.setFirstItem(context: Context, items: Array<String>) {
    val adapter = ArrayAdapter(
        context,
        android.R.layout.simple_list_item_1,
        items
    )

    setAdapter(adapter)
    setText(adapter.getItem(0).toString(), false)
}

val String.withoutWhitespace: String
    get() = this.replace("\\s".toRegex(), "")