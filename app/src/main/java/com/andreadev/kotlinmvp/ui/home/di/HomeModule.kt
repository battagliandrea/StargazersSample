package com.andreadev.kotlinmvp.ui.home.di

import com.andreadev.kotlinmvp.data.repository.RootRepository
import com.andreadev.kotlinmvp.di.PresenterScope
import com.andreadev.kotlinmvp.ui.home.HomePresenter
import dagger.Module
import dagger.Provides

/**
 * Created by andrea on 19/09/17.
 */

@Module
class HomeModule {

    @PresenterScope
    @Provides
    fun provideSplashPresenter(rootRepository: RootRepository): HomePresenter = HomePresenter(rootRepository)
}