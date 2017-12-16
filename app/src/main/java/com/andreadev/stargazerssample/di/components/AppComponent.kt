package com.andreadev.stargazerssample.di.components

import android.content.Context
import com.andreadev.stargazerssample.App
import com.andreadev.stargazerssample.api.GithubApi
import com.andreadev.stargazerssample.data.repository.GithubRepository
import com.andreadev.stargazerssample.data.repository.PreferencesRepository
import com.andreadev.stargazerssample.di.AppContext
import com.andreadev.stargazerssample.di.modules.*
import dagger.Component
import javax.inject.Singleton

/**
 * Created by andrea on 26/08/2017.
 */

@Singleton
@Component(modules = arrayOf(AppModule::class, ApiServiceModule::class, DataModule::class, NetworkModule::class))
interface AppComponent {

    fun inject(app: App)

    @AppContext
    fun context(): Context
    fun app(): App

    fun api(): GithubApi

    fun githubRepository() : GithubRepository
    fun preferencesRepository() : PreferencesRepository
}