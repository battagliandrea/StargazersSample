package com.andreadev.stargazerssample

import android.app.Application
import com.andreadev.stargazerssample.di.components.AppComponent
import com.andreadev.stargazerssample.di.components.DaggerAppComponent
import com.andreadev.stargazerssample.di.modules.*

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