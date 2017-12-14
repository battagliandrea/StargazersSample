package com.andreadev.kotlinmvp.ui.home

import com.andreadev.kotlinmvp.data.repository.RootRepository
import com.andreadev.poikotlin.ui.base.BaseMvpPresenter
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

/**
 * Created by andrea on 16/08/2017.
 */
class HomePresenter(val rootRepository: RootRepository) : BaseMvpPresenter<HomeView>() {

    private val TAG = HomePresenter::class.java.simpleName

    open fun getList() {
        mView?.showLoading()
        Observable.just(rootRepository.rootList()
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        { data ->
                            getView()?.rootListSuccess(data.getList())
                            mView?.hideLoading()
                        },
                        { error ->
                            error.printStackTrace()
                            getView()?.rootListError()
                            mView?.hideLoading()
                        })
                )
    }
}