package com.andreadev.stargazerssample.ui.repolist

import android.content.Context
import android.content.Intent
import android.os.Bundle
import com.andreadev.stargazerssample.ui.base.activity.BaseToolbarActivity

class StargazersActivity : BaseToolbarActivity() {

    companion object {
        fun getIntent(context: Context): Intent = Intent(context, StargazersActivity::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        replaceFragment(StargazersFragment.newIstance())
    }
}
