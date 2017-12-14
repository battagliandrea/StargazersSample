package com.andreadev.kotlinmvp.di.components

import android.content.Context
import com.andreadev.kotlinmvp.App
import com.andreadev.kotlinmvp.api.AndreaDevApi
import com.andreadev.kotlinmvp.di.AppContext
import com.andreadev.kotlinmvp.di.modules.*
import com.andreadev.kotlinmvp.scheduler.RxSchedulers
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