package com.andreadev.stargazerssample.ui.base
/**
 * Created by andrea on 18/08/2017.
 */

interface BaseMvpView {

    fun showError(error: String?)
    fun showMessage(message: String)

    fun showLoading()
    fun hideLoading()
}