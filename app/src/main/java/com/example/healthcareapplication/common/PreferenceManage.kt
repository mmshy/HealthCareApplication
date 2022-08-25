package com.example.healthcareapplication.common

import android.content.Context
import android.content.SharedPreferences
import android.content.SharedPreferences.OnSharedPreferenceChangeListener
import android.util.Log
import androidx.preference.PreferenceManager
import com.example.healthcareapplication.domain.model.User
import com.google.gson.Gson
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.CoroutineDispatcher
import javax.inject.Inject

class PreferenceManage @Inject constructor(
    @ApplicationContext val context: Context
) {

    private var sharedPreferences: SharedPreferences = PreferenceManager.getDefaultSharedPreferences(context)

    init{

    }

    fun clear() {
        val editor = sharedPreferences.edit()
        editor.clear()
        editor.apply()
    }

    fun registerChangesListener(listener: OnSharedPreferenceChangeListener?) {
        sharedPreferences.registerOnSharedPreferenceChangeListener(listener)
    }

    fun unRegisterChangesListener(listener: OnSharedPreferenceChangeListener?) {
        sharedPreferences.unregisterOnSharedPreferenceChangeListener(listener)
    }

    // region -------------- ACCESSORS --------------
    fun putBoolean(key: String?, value: Boolean?) {
        val editor = sharedPreferences.edit()
        editor.putBoolean(key, value!!)
        editor.apply()
    }

    fun getBoolean(key: String?): Boolean {
        return sharedPreferences.getBoolean(key, false)
    }

    fun putUser(value: User?) {
        val editor = sharedPreferences.edit()
        val gson = Gson()
        val json: String = gson.toJson(value)
        editor.putString(Constants.KEY_CURRENT_USER, json)
        editor.apply()
    }

    fun getUser(): User? {
        val gson = Gson()
        val json = sharedPreferences.getString(Constants.KEY_CURRENT_USER, null)
        return gson.fromJson(json, User::class.java)
    }

    fun putString(key: String?, value: String?) {
        val editor = sharedPreferences.edit()
        editor.putString(key, value)
        editor.apply()
    }

    fun getString(key: String?): String? {
        return sharedPreferences.getString(key, null)
    }
    // endregion
}