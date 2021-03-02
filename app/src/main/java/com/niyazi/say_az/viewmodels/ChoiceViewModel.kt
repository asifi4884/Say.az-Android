package com.niyazi.say_az.viewmodels

import android.content.Context
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel
import dagger.hilt.android.qualifiers.ApplicationContext

/**
 * Created by Niyazi on 12/25/2020.
 */
class ChoiceViewModel @ViewModelInject constructor(
    @ApplicationContext val appContext: Context
) : ViewModel() {

//    fun setLang(values: Array<String>, indices: Int) {
//
//    }

//    fun setMode(values: Array<String>, indices: Int) {
//        Timber.i("${values[indices]}")
//        appContext.apply {
//            when (values[indices]) {
//                context.getString(R.string.msg_mode_default) -> {
//                    PreferenceManager.getInstance(this)
//                        .setUiMode(SYSTEM_DEFAULT)
//                }
//                context.getString(R.string.msg_mode_light) -> {
//                    PreferenceManager.getInstance(this).setUiMode(AppCompatDelegate.MODE_NIGHT_NO)
//                }
//                resources.getString(R.string.msg_mode_night) -> {
//                    PreferenceManager.getInstance(this).setUiMode(AppCompatDelegate.MODE_NIGHT_YES)
//                }
//            }
//            Timber.i(
//                "${
//                    PreferenceManager.getInstance(this).getUiModeOn()
//                } ${resources.getString(R.string.msg_mode_night)}"
//            )
//            PreferenceManager.getInstance(this).getUiModeOn().setUiMode(this)
//        }
//    }

}