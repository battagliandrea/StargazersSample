package com.andreadev.kotlinmvp.di.modules

import android.content.Context
import android.content.SharedPreferences
import com.andreadev.kotlinmvp.di.AppContext
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * Created by andrea on 26/08/2017.
 */
@Module
open class DataModule() {

    @Provides
    @Singleton
    fun provideSharedPreferences(@AppContext context: Context): SharedPreferences {
        return context.getSharedPreferences("kotlinmvp-prefs", Context.MODE_PRIVATE)//:TODO change shared pref key
    }
}