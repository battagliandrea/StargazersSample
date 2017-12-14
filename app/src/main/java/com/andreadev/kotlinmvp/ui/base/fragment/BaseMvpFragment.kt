package com.andreadev.poikotlin.ui.base

import android.os.Bundle
import android.support.v4.app.Fragment
import android.widget.Toast
import com.andreadev.kotlinmvp.ui.home.HomeFragment
import com.andreadev.kotlinmvp.ui.widget.ProgressFragment

/**
 * Created by andrea on 18/08/2017.
 */
abstract class BaseMvpFragment<in V : BaseMvpView, T : BasePresenter<V>> : Fragment(), BaseMvpView {

    protected val TAG = HomeFragment::class.java.simpleName

    protected lateinit var mPresenter: T

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        mPresenter = instancePresenter()
        mPresenter.attachView(this as V)
    }

    override fun onDestroy() {
        super.onDestroy()
        mPresenter.detachView()
    }

    protected abstract fun instancePresenter(): T

    override fun showError(error: String?) {
        Toast.makeText(activity, error, Toast.LENGTH_LONG).show()
    }

    override fun showMessage(message: String) {
        Toast.makeText(activity, message, Toast.LENGTH_LONG).show()
    }

    override fun showLoading() {
        (activity as BaseActivity).showLoading()
    }

    override fun hideLoading() {
        (activity as BaseActivity).hideLoading()
    }
}