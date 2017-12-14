package com.andreadev.stargazerssample.ui.home

import android.content.Context
import android.content.Intent
import android.os.Bundle
import com.andreadev.stargazerssample.ui.base.activity.BaseToolbarActivity
import com.andreadev.stargazerssample.ui.home.HomeFragment

class HomeActivity : BaseToolbarActivity() {

    companion object {
        fun getIntent(context: Context): Intent = Intent(context, HomeActivity::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        replaceFragment(HomeFragment.newIstance())
    }
}
