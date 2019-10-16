package com.chegsmania.triptotracker.views.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.chegsmania.triptotracker.R
import com.chegsmania.triptotracker.remote.AuthModel
import com.chegsmania.triptotracker.utils.AuthInterface
import com.chegsmania.triptotracker.utils.AuthRepository
import kotlinx.android.synthetic.main.activity_signin.*
import kotlinx.android.synthetic.main.activity_signup.*

class SignupActivity : AppCompatActivity(), View.OnClickListener, AuthInterface {

    private val TAG = SigninActivity::class.java.simpleName
    private var repository: AuthRepository? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup)
        signupBackButton.setOnClickListener(this)
        signupSubmitButton.setOnClickListener(this)
        repository = AuthRepository(this)
    }

    override fun onClick(item: View?) {
        when{
            item!!.id == R.id.signupBackButton -> {
                onBackPressed()
                finish()
            }
            item.id == R.id.signupSubmitButton -> {
                signUpUser()
            }
        }
    }

    private fun signUpUser(){
        val user = AuthModel.User(
            signinEmailEdittext.text.toString().trim(),
            signinPasswordEdittext.text.toString().trim()
        )
        repository?.registerUser(user)
    }

    override fun userLogin(user: AuthModel.User) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun userRegister(user: AuthModel.User) {
        startActivity(Intent(this, SigninActivity::class.java))
        overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out)
        finish()
    }
}
