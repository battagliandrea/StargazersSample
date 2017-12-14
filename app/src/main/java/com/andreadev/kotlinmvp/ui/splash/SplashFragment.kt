package com.andreadev.kotlinmvp.ui.splash

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.andreadev.kotlinmvp.App
import com.andreadev.kotlinmvp.R
import com.andreadev.kotlinmvp.di.components.DaggerPresenterComponent
import com.andreadev.poikotlin.route.RouteManager
import com.andreadev.poikotlin.ui.base.BaseMvpFragment
import com.andreadev.poikotlin.ui.splash.SplashPresenter
import com.andreadev.poikotlin.ui.splash.SplashView
import javax.inject.Inject

/**
 * A placeholder fragment containing a simple view.
 */
class SplashFragment : BaseMvpFragment<SplashView, SplashPresenter>(), SplashView {

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //
    //                                                  INIT
    //
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    @Inject
    lateinit var splashPresenter : SplashPresenter

    companion object Instance{
        fun newIstance(): SplashFragment = SplashFragment()
    }

    init {
        DaggerPresenterComponent.builder().appComponent(App.component).build().inject(this)
    }

    override fun instancePresenter(): SplashPresenter = splashPresenter


    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //
    //                                                  FRAGMENT
    //
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater!!.inflate(R.layout.fragment_splash, container, false)
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mPresenter.resume()
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //
    //                                                  VIEW
    //
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    override fun navigateToHome() {
        RouteManager.home(this)
        activity.finish()
    }


}

