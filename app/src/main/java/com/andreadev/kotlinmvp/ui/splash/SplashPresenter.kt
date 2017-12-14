package com.andreadev.poikotlin.ui.splash

import com.andreadev.poikotlin.ui.base.BaseMvpPresenter
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import java.util.concurrent.TimeUnit

/**
 * Created by andrea on 16/08/2017.
 */
class SplashPresenter : BaseMvpPresenter<SplashView>() {

    private val TAG = SplashPresenter::class.java.simpleName

    open fun resume(){
       Observable.just(true)
               .delay(2000, TimeUnit.MILLISECONDS)
               .subscribeOn(Schedulers.newThread())
               .observeOn(AndroidSchedulers.mainThread())
               .subscribe(
                       {t ->  getView()?.navigateToHome()},
                       {t: Throwable ->  getView()?.showError("Error: " + t.message)})
    }
}