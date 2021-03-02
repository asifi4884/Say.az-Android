package com.niyazi.say_az

import android.app.Application
import com.niyazi.say_az.manager.PreferenceManager
import com.niyazi.say_az.utils.extensions.setUiMode
import dagger.hilt.android.HiltAndroidApp
import timber.log.Timber

/**
 * Created by Niyazi on 12/19/2020.
 */
@HiltAndroidApp
class ApplicationController : Application() {
    override fun onCreate() {
        super.onCreate()
        Timber.plant(Timber.DebugTree())
        PreferenceManager.getInstance(applicationContext).getUiModeOn().setUiMode(applicationContext)
    }
}