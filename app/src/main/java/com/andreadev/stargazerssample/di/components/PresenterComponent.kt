package com.andreadev.stargazerssample.di.components

import com.andreadev.stargazerssample.di.PresenterScope
import com.andreadev.stargazerssample.di.modules.PresenterModule
import com.andreadev.stargazerssample.ui.home.HomeFragment
import com.andreadev.stargazerssample.ui.splash.SplashFragment
import dagger.Component

/**
 * Created by andrea on 26/08/2017.
 */

@PresenterScope
@Component(dependencies = arrayOf(AppComponent::class), modules = arrayOf(PresenterModule::class))
interface PresenterComponent {

    fun inject(splashFragment: SplashFragment)
    fun inject(homeFragment: HomeFragment)

}