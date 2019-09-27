package com.chegsmania.triptotracker.views.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.chegsmania.triptotracker.R
import kotlinx.android.synthetic.main.activity_signin.*

class SigninActivity : AppCompatActivity(), View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signin)
        signInBackButton.setOnClickListener(this)
        signinSubmitButton.setOnClickListener(this)
    }

    override fun onClick(item: View?) {
        when{
            item!!.id == R.id.signInBackButton -> {
                onBackPressed()
                finish()
            }
            item.id == R.id.signinSubmitButton -> {
                val intent = Intent(this, DashboardActivity::class.java)
                startActivity(intent)
                overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out)
                finish()
            }
        }
    }
}
