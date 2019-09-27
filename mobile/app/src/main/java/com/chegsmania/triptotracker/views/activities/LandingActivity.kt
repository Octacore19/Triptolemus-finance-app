package com.chegsmania.triptotracker.views.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.chegsmania.triptotracker.R
import kotlinx.android.synthetic.main.activity_landing.*

class LandingActivity : AppCompatActivity(), View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_landing)
        landingSigninButton.setOnClickListener(this)
        landingSignupButton.setOnClickListener(this)
    }
    override fun onClick(item: View?) {
        when{
            item!!.id == R.id.landingSigninButton -> {
                val intent = Intent(this, SigninActivity::class.java)
                startActivity(intent)
                overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out)
            }

            item.id == R.id.landingSignupButton -> {
                val intent = Intent(this, SignupActivity::class.java)
                startActivity(intent)
                overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out)
            }
        }
    }
}
