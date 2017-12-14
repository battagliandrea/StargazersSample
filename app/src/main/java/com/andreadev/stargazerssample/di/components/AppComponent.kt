package com.andreadev.stargazerssample.di.components

import android.content.Context
import com.andreadev.stargazerssample.App
import com.andreadev.stargazerssample.api.AndreaDevApi
import com.andreadev.stargazerssample.di.AppContext
import com.andreadev.stargazerssample.di.modules.*
import com.andreadev.stargazerssample.scheduler.RxSchedulers
import dagger.Component
import javax.inject.Singleton

/**
 * Created by andrea on 26/08/2017.
 */

@Singleton
@Component(modules = arrayOf(AppModule::class, ApiServiceModule::class, DataModule::class, NetworkModule::class, RxModule::class))
interface AppComponent {

    fun inject(app: App)

    @AppContext
    fun context(): Context
    fun app(): App

    fun rxSchedulers(): RxSchedulers
    fun api(): AndreaDevApi

}