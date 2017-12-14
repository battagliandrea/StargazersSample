package com.andreadev.kotlinmvp.ui.splash.di

import com.andreadev.kotlinmvp.di.PresenterScope
import com.andreadev.poikotlin.ui.splash.SplashPresenter
import dagger.Module
import dagger.Provides

/**
 * Created by andrea on 19/09/17.
 */
@Module
class SplashModule {

    @PresenterScope
    @Provides
    fun provideSplashPresenter(): SplashPresenter = SplashPresenter()
}