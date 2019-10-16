package com.chegsmania.triptotracker.utils

import android.app.Application

class BaseApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        Session.initSharedPreferences(applicationContext)
    }
}