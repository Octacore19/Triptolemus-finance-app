package com.chegsmania.triptotracker.utils

import com.chegsmania.triptotracker.remote.AuthModel

interface AuthInterface {
    fun userLogin(user: AuthModel.User)
    fun userRegister(user: AuthModel.User)
}