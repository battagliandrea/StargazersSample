package com.andreadev.stargazerssample.di.modules

import android.content.Context
import android.content.SharedPreferences
import com.andreadev.stargazerssample.di.AppContext
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
        return context.getSharedPreferences("stargazerssample-prefs", Context.MODE_PRIVATE)
    }
}