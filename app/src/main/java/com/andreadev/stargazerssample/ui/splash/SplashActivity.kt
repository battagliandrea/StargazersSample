package com.andreadev.stargazerssample.ui.splash

import android.os.Bundle
import com.andreadev.stargazerssample.ui.base.BaseActivity

class SplashActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        replaceFragment(SplashFragment.newIstance())
    }
}
