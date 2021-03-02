package com.niyazi.say_az.manager

import android.content.Context
import android.content.SharedPreferences
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.niyazi.say_az.R
import com.niyazi.say_az.data.MyBankAccountsData
import com.niyazi.say_az.utils.Language
import com.niyazi.say_az.utils.Preference
import com.niyazi.say_az.utils.SYSTEM_DEFAULT
import timber.log.Timber
import java.lang.reflect.Type


/**
 * Created by Niyazi on 11/25/2020.
 */
class PreferenceManager private constructor(val context: Context) {

    companion object : SingletonHolder<PreferenceManager, Context>(::PreferenceManager)

    private var sharedPreferences: SharedPreferences? = null

    init {
        sharedPreferences = context.getSharedPreferences(
            context.resources.getString(R.string.preference_file_key),
            Context.MODE_PRIVATE
        )
    }

    private fun setStringElement(key: String, value: String) {
        with(sharedPreferences?.edit()) {
            this?.putString(key, value)
            this?.apply()
        }
    }

    private fun getStringElement(key: String, defaultValue: String): String? {
        return sharedPreferences?.getString(key, defaultValue)
    }

    private fun setIntElement(key: String, value: Int) {
        with(sharedPreferences?.edit()) {
            this?.putInt(key, value)
            this?.apply()
        }
    }

    private fun getIntElement(key: String, defaultValue: Int): Int? {
        return sharedPreferences?.getInt(key, defaultValue)
    }

    private fun setBooleanElement(key: String, value: Boolean) {
        with(sharedPreferences?.edit()) {
            this?.putBoolean(key, value)
            this?.apply()
        }
    }

    private fun getBooleanElement(key: String, defaultValue: Boolean): Boolean? {
        return sharedPreferences?.getBoolean(key, defaultValue)
    }

    fun setLogin(value: Boolean) {
        setBooleanElement(Preference.LOGIN, value)
    }

    fun isLogin(): Boolean = getBooleanElement(Preference.LOGIN, false)!!

    fun setUiMode(value: Int) {
        Timber.i("$value")
        setIntElement(Preference.UI_MODE, value)
    }

    fun getUiModeOn(): Int = getIntElement(Preference.UI_MODE, SYSTEM_DEFAULT)!!

    fun setLang(value: String) {
        setStringElement(Preference.LANG, value)
    }

    fun getLang(): String = getStringElement(Preference.LANG, Language.LANG_DEFAULT)!!

    fun setTestAccountsArrayList(list: ArrayList<MyBankAccountsData?>?) {
        val gson = Gson()
        val json = gson.toJson(list)
        setStringElement(Preference.TEST_ACCOUNTS_LIST, json)
    }

    fun getTestAccountsArrayList(): ArrayList<MyBankAccountsData?>? {
        val gson = Gson()
        val json = getStringElement(Preference.TEST_ACCOUNTS_LIST, "")
        val type: Type = object : TypeToken<ArrayList<MyBankAccountsData?>?>() {}.type
        return gson.fromJson(json, type)
    }

}
