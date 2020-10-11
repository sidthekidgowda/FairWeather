package com.android.sidthekidgowda.fairweather.view

import android.os.Bundle
import android.view.Menu
import androidx.appcompat.app.AppCompatActivity
import com.android.sidthekidgowda.fairweather.R
import kotlinx.android.synthetic.main.activity_main.*

class HomeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayShowTitleEnabled(false)

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.navigation_icons, menu)
        return true
    }
}
