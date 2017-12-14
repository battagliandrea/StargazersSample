package com.andreadev.stargazerssample.ui.home

import com.andreadev.stargazerssample.ui.base.BaseMvpView

/**
 * Created by andrea on 18/08/2017.
 */
interface HomeView : BaseMvpView {

    abstract fun rootListSuccess(data : List<String>)
    abstract fun rootListError()
}