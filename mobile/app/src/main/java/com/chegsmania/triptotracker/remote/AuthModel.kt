package com.chegsmania.triptotracker.remote

object AuthModel {

    data class AuthResponse(val token: String,
                            val user: User,
                            val success: String)

    data class User(val username: String,
                    val email: String,
                    val password: String){
        constructor(email: String,
                    password: String) : this("", email, password)
    }

    data class Item(val name: String,
                    val description: String,
                    val amount: String,
                    val date: String,
                    val user_id: String){
        constructor(name: String,
                    description: String,
                    amount: String,
                    date: String) : this(name, description, amount, date, " ")
    }
}