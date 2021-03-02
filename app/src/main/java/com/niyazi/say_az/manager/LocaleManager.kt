package com.niyazi.say_az.manager

import android.content.Context
import androidx.fragment.app.Fragment

/**
 * Created by Niyazi on 3/9/2020
 */
fun Context.setNewLocale(language: String): Context {
    return this.apply {
        val locale = java.util.Locale(language)
        java.util.Locale.setDefault(locale)
        val config = android.content.res.Configuration()
        config.setLocale(locale)
        resources.updateConfiguration(
            config,
            resources.displayMetrics
        )
    }
}