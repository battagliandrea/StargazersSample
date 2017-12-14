package com.andreadev.kotlinmvp.di.modules

import android.content.Context
import com.andreadev.kotlinmvp.App
import com.andreadev.kotlinmvp.di.AppContext
import dagger.Module
import dagger.Provides

/**
 * Created by andrea on 26/08/2017.
 */


@Module
open class AppModule(val app: App) {

    @Provides
    fun provideApp() : App {
        return app
    }

    @Provides  @AppContext
    fun provideContext(): Context {
        return app
    }
}