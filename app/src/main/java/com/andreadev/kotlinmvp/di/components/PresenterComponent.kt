package com.andreadev.kotlinmvp.di.components

import com.andreadev.kotlinmvp.di.PresenterScope
import com.andreadev.kotlinmvp.ui.home.HomeFragment
import com.andreadev.kotlinmvp.ui.home.di.HomeModule
import com.andreadev.kotlinmvp.ui.splash.SplashFragment
import com.andreadev.kotlinmvp.ui.splash.di.SplashModule
import dagger.Component

/**
 * Created by andrea on 26/08/2017.
 */

@PresenterScope
@Component(dependencies = arrayOf(AppComponent::class), modules = arrayOf(SplashModule::class, HomeModule::class))
interface PresenterComponent {

    fun inject(splashFragment: SplashFragment)
    fun inject(homeFragment: HomeFragment)

}