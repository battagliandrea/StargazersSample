package com.andreadev.kotlinmvp.ui.home

import com.andreadev.poikotlin.ui.base.BaseMvpView

/**
 * Created by andrea on 18/08/2017.
 */
interface HomeView : BaseMvpView {

    abstract fun rootListSuccess(data : List<String>)
    abstract fun rootListError()
}