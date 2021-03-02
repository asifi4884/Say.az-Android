package com.niyazi.say_az.utils

import androidx.annotation.Keep
import com.niyazi.say_az.R

/**
 * Created by Niyazi on 12/18/2020.
 */
const val START_UP_TIME = 2000L
const val COUNT_DOWN_INTERVAL = 1000L
const val INTRO_IMG = "INTRO_IMG"
const val INTRO_TITLE_ID = "INTRO_TITLE"
const val INTRO_BODY = "INTRO_BODY"
const val SYSTEM_DEFAULT = -1000
const val TAX_MINISTRY_MAIL = "office@taxes.gov.az"
const val CARD_NUMBER = "CARD_NUMBER"
val NON_DIGIT = Regex("[^\\d]")

object Preference {
    const val LOGIN: String = "Login"
    const val UI_MODE: String = "UI_MODE"
    const val LANG: String = "LANG"
    const val TEST_ACCOUNTS_LIST="TEST_ACCOUNTS_LIST"
}

object Language {
    const val LANG_DEFAULT = ""
    const val LANG_AZ = "az"
    const val LANG_EN = "en"
    const val LANG_RU = "ru"
}

@Keep
enum class DialogDesign(val color: Int, val title: Int) {
    ERROR(R.color.colorRed, R.string.error_title),
    SUCCESS(R.color.colorGreen, R.string.title_congratulation),
}

@Keep
enum class ListDialog() {
    LANG, TERM, MODE, RECEIPTS
}