package com.chegsmania.triptotracker.remote

import kotlinx.coroutines.Deferred
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.Headers
import retrofit2.http.POST

interface TrackerApiInterface {
    @POST("auth/register")
    fun registerUser(@Body user: AuthModel.User) : Deferred<Response<AuthModel.AuthResponse>>

    @Headers("Content-Type: application/json")
    @POST("auth/login")
    fun loginUserAsync(@Body user: AuthModel.User) : Deferred<Response<AuthModel.AuthResponse>>
}