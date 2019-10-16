package com.chegsmania.triptotracker.utils

import android.app.Activity
import android.util.Log
import com.chegsmania.triptotracker.remote.AuthModel
import com.chegsmania.triptotracker.remote.TrackerApiService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class AuthRepository(activity: Activity) {

    private val TAG = AuthRepository::class.java.simpleName
    private val service = TrackerApiService.createService()
    private var mInterface: AuthInterface? = null

    init {
        mInterface = activity as AuthInterface
    }

    fun loginUser(user: AuthModel.User) {
        GlobalScope.launch(Dispatchers.Main) {
            val request = service.loginUserAsync(user)
            try {
                val response = request.await()
                if (response.isSuccessful) {
                    val body = response.body()
                    if (Session.getToken() == null) {
                        Session.storeToken(body!!.token)
                    } else if (Session.getToken() != body!!.token) {
                        Session.storeToken(body.token)
                    }
                    mInterface?.userLogin(body.user)
                    Log.i(TAG, "Auth token: " + body.token)
                } else {
                    Log.e(TAG, response.errorBody()!!.string())
                }
            } catch (err: Exception) {
                err.printStackTrace()
            }
        }
    }

    fun registerUser(user: AuthModel.User) {
        GlobalScope.launch(Dispatchers.Main) {
            val request = service.registerUser(user)
            try {
                val response = request.await()
                if (response.isSuccessful) {
                    val body = response.body()
                    Session.storeToken(body!!.token)
                    mInterface?.userRegister(body.user)
                } else {
                    Log.e(TAG, response.errorBody()!!.string())
                }
            } catch (err: Exception) {
                err.printStackTrace()
            }
        }
    }
}