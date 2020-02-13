package com.example.contactapplication.userinterface

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.databinding.DataBindingUtil
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
import com.example.contactapplication.R
import com.example.contactapplication.databinding.ActivityContactBinding
import com.example.contactapplication.utils.SettingsActivity
import kotlinx.android.synthetic.main.activity_contact.*

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityContactBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_contact)
        setSupportActionBar(toolbarall)


        val navHostFragment = supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        val navController = navHostFragment.navController
        NavigationUI.setupActionBarWithNavController(this, navController)

    }
    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        super.onCreateOptionsMenu(menu)
        menuInflater.inflate(R.menu.tools_menu_bar, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == R.id.settingpage) {
            startActivity(Intent(this, SettingsActivity::class.java))
        }
        if (item.itemId == R.id.logout) {
            val sharedPreferences: SharedPreferences =
                getSharedPreferences("loginref", Context.MODE_PRIVATE)
            sharedPreferences.edit().clear().apply()
            finish()
        }
        return true
    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = this.findNavController(R.id.nav_host_fragment)
        return navController.navigateUp()
    }





}
