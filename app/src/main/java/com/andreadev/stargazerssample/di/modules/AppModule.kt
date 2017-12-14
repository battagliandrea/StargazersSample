package com.andreadev.stargazerssample.di.modules

import android.content.Context
import com.andreadev.stargazerssample.App
import com.andreadev.stargazerssample.di.AppContext
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