package com.chegsmania.triptotracker.views.activities

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.chegsmania.triptotracker.R
import com.chegsmania.triptotracker.remote.AuthModel
import com.chegsmania.triptotracker.utils.AuthInterface
import com.chegsmania.triptotracker.utils.AuthRepository
import com.chegsmania.triptotracker.utils.Session
import kotlinx.android.synthetic.main.activity_signin.*

class SigninActivity : AppCompatActivity(), View.OnClickListener, AuthInterface {

    private val TAG = SigninActivity::class.java.simpleName
    private var repository: AuthRepository? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signin)
        signInBackButton.setOnClickListener(this)
        signinSubmitButton.setOnClickListener(this)
        repository = AuthRepository(this)
    }

    override fun onClick(item: View?) {
        when {
            item!!.id == R.id.signInBackButton -> {
                onBackPressed()
                finish()
            }
            item.id == R.id.signinSubmitButton -> {
                loginUser()
            }
        }
    }

    private fun loginUser() {
        val user = AuthModel.User(
            signinEmailEdittext.text.toString().trim(),
            signinPasswordEdittext.text.toString().trim()
        )
        repository?.loginUser(user)
    }

    override fun userLogin(user: AuthModel.User) {
        startActivity(Intent(this, DashboardActivity::class.java))
        overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out)
        finish()
    }

    override fun userRegister(user: AuthModel.User) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}
