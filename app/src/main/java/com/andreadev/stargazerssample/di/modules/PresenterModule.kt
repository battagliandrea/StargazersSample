package com.andreadev.stargazerssample.di.modules

import com.andreadev.stargazerssample.data.repository.GithubRepository
import com.andreadev.stargazerssample.di.PresenterScope
import com.andreadev.stargazerssample.ui.repolist.StargazersPresenter
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
    fun provideStargazersPresenter(githubRepository: GithubRepository): StargazersPresenter = StargazersPresenter(githubRepository)

}