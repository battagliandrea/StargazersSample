package com.andreadev.stargazerssample.di.modules

import com.andreadev.stargazerssample.scheduler.AppRxSchedulers
import com.andreadev.stargazerssample.scheduler.RxSchedulers
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