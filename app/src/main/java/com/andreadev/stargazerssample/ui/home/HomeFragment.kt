package com.andreadev.stargazerssample.ui.home

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.andreadev.stargazerssample.App
import com.andreadev.stargazerssample.R
import com.andreadev.stargazerssample.di.components.DaggerPresenterComponent
import com.andreadev.stargazerssample.ui.base.BaseMvpFragment
import kotlinx.android.synthetic.main.fragment_home.*
import javax.inject.Inject

/**
 * A placeholder fragment containing a simple view.
 */
class HomeFragment : BaseMvpFragment<HomeView, HomePresenter>(), HomeView {

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //
    //                                                  INIT
    //
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    @Inject
    lateinit var homePresenter : HomePresenter

    companion object Instance{
        fun newIstance(): HomeFragment = HomeFragment()
    }

    init {
        DaggerPresenterComponent.builder().appComponent(App.component).build().inject(this)
    }

    override fun instancePresenter(): HomePresenter = homePresenter


    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //
    //                                                  FRAGMENT
    //
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    private lateinit var adapter : HomeAdapter


    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater!!.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mPresenter.getList()

        adapter = HomeAdapter()
        rv.layoutManager = LinearLayoutManager(activity)
        rv.adapter = adapter
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //
    //                                                  VIEW
    //
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    override fun rootListSuccess(data: List<String>) {
        Log.d(TAG, data.toString())
        adapter.setData(data)
    }

    override fun rootListError() {
        Toast.makeText(activity, "ERRORE!", Toast.LENGTH_SHORT).show()
    }
}