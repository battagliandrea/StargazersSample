package com.andreadev.stargazerssample.ui.base
/**
 * Created by andrea on 18/08/2017.
 */

interface BaseMvpView {

    fun isAttached() : Boolean

    fun showError(string: String?)
    fun showError(throwable: Throwable)

    fun showLoading()
    fun hideLoading()
}