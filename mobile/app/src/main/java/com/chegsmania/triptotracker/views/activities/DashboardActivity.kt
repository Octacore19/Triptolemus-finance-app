package com.chegsmania.triptotracker.views.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import androidx.appcompat.widget.PopupMenu
import com.chegsmania.triptotracker.R
import com.chegsmania.triptotracker.utils.Session
import kotlinx.android.synthetic.main.activity_dashboard.*
import kotlinx.android.synthetic.main.expense_tracking_layout.*

class DashboardActivity : AppCompatActivity(), View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard)
        setSupportActionBar(dashboardToolbar)
        generateButton.setOnClickListener(this)

        /*if(Session.getToken() == null){
            startActivity(Intent(this, LandingActivity::class.java))
            overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out)
            finish()
        }*/
    }

    override fun onClick(item: View?) {
        when{
            item!!.id == R.id.generateButton -> {
                expenseTransactionLayout.visibility = View.VISIBLE
            }
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.dashboard_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when{
            item.itemId == R.id.openDropdownMenu -> {
//                showPopupMenu()
            }
        }
        return super.onOptionsItemSelected(item)
    }

    private fun showPopupMenu(view: View) {
        /*val popupMenu = PopupMenu(this, view)
        popupMenu.menuInflater.inflate(R.menu.dashboard_popup_menu, popupMenu.menu)
        popupMenu.show()*/
    }
}
