package com.andreadev.stargazerssample.ui.splash

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.andreadev.stargazerssample.App
import com.andreadev.stargazerssample.R
import com.andreadev.stargazerssample.di.components.DaggerPresenterComponent
import com.andreadev.stargazerssample.route.RouteManager
import com.andreadev.stargazerssample.ui.base.BaseMvpFragment
import com.andreadev.stargazerssample.ui.splash.SplashPresenter
import com.andreadev.stargazerssample.ui.splash.SplashView
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

