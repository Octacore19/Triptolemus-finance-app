package com.chegsmania.triptotracker.utils

import android.content.Context
import android.content.SharedPreferences

class Session private constructor(){
    companion object {

        private lateinit var sharedPreference: SharedPreferences

        private const val AUTH_TOKEN_NAME = "usertoken"
        private const val AUTH_TOKEN = "token"

        fun initSharedPreferences(context: Context) {
            sharedPreference = context.getSharedPreferences(AUTH_TOKEN_NAME, Context.MODE_PRIVATE)
        }

        private fun setSharedPreferences(): SharedPreferences.Editor =
            getsharedPreferences().edit()

        private fun getsharedPreferences(): SharedPreferences = sharedPreference

        fun storeToken(token: String) =
            setSharedPreferences().putString(AUTH_TOKEN, token).apply()

        fun getToken(): String? = getsharedPreferences().getString(AUTH_TOKEN, null)
    }
}