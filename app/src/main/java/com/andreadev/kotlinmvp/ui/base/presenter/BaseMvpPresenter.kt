package com.andreadev.poikotlin.ui.base

/**
 * Created by andrea on 18/08/2017.
 */
open class BaseMvpPresenter<V : BaseMvpView> : BasePresenter<V> {

    protected var mView : V? = null

    override fun attachView(view: V) {
        mView = view
    }

    override fun detachView() {
        mView = null
    }

    fun getView() : V?{
        return mView
    }
}