package com.andreadev.kotlinmvp

import android.app.Application
import com.andreadev.kotlinmvp.di.components.AppComponent
import com.andreadev.kotlinmvp.di.components.DaggerAppComponent
import com.andreadev.kotlinmvp.di.modules.*

/**
 * Created by andrea on 26/08/2017.
 */
class App : Application() {

    companion object {
        @JvmStatic lateinit var component: AppComponent
    }

    override fun onCreate() {
        super.onCreate()
        component = DaggerAppComponent
                .builder()
                .appModule(AppModule(this))
                .apiServiceModule(ApiServiceModule())
                .networkModule(NetworkModule())
                .rxModule(RxModule())
                .build()
        component.inject(this)
    }
}