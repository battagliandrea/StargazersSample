package com.andreadev.stargazerssample.di.modules

import android.support.v7.view.menu.MenuPresenter
import com.andreadev.stargazerssample.data.repository.PreferencesRepository
import com.andreadev.stargazerssample.data.repository.RootRepository
import com.andreadev.stargazerssample.di.PresenterScope
import com.andreadev.stargazerssample.ui.home.HomePresenter
import com.andreadev.stargazerssample.ui.splash.SplashPresenter
import dagger.Module
import dagger.Provides

/**
 * Created by andrea on 14/11/2017.
 */
@PresenterScope
@Module
class PresenterModule {

    @PresenterScope
    @Provides
    fun provideSplashPresenter(): SplashPresenter = SplashPresenter()

    @PresenterScope
    @Provides
    fun provideHomePresenter(rootRepository: RootRepository): HomePresenter = HomePresenter(rootRepository)

}