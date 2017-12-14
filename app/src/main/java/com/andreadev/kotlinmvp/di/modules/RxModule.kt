package com.andreadev.kotlinmvp.di.modules

import com.andreadev.kotlinmvp.scheduler.AppRxSchedulers
import com.andreadev.kotlinmvp.scheduler.RxSchedulers
import dagger.Module
import dagger.Provides

/**
 * Created by andrea on 27/08/2017.
 */
@Module
class RxModule {

    @Provides
    internal fun provideRxSchedulers(): RxSchedulers {
        return AppRxSchedulers()
    }
}