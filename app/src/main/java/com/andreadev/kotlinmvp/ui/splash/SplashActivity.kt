package com.andreadev.kotlinmvp.ui.splash

import android.os.Bundle
import com.andreadev.poikotlin.ui.base.BaseActivity

class SplashActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        replaceFragment(SplashFragment.newIstance())
    }
}
