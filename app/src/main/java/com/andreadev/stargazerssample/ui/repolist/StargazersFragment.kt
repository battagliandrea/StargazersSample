package com.andreadev.stargazerssample.ui.repolist

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.andreadev.stargazerssample.App
import com.andreadev.stargazerssample.R
import com.andreadev.stargazerssample.data.models.Stargazer
import com.andreadev.stargazerssample.di.components.DaggerPresenterComponent
import com.andreadev.stargazerssample.ui.base.BaseMvpFragment
import kotlinx.android.synthetic.main.fragment_stargazers.*
import javax.inject.Inject

/**
 * A placeholder fragment containing a simple view.
 */
class StargazersFragment : BaseMvpFragment<StargazersView, StargazersPresenter>(), StargazersView {

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //
    //                                                  INIT
    //
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    @Inject
    lateinit var stargazersPresenter: StargazersPresenter

    companion object Instance{
        fun newIstance(): StargazersFragment = StargazersFragment()
    }

    init {
        DaggerPresenterComponent.builder().appComponent(App.component).build().inject(this)
    }

    override fun instancePresenter(): StargazersPresenter = stargazersPresenter


    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //
    //                                                  FRAGMENT
    //
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    private lateinit var adapter : StargazersAdapter


    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater!!.inflate(R.layout.fragment_stargazers, container, false)
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mPresenter.loadStargazersList()

        adapter = StargazersAdapter(activity, mAdapterListener)
        rv.layoutManager = LinearLayoutManager(activity)
        rv.adapter = adapter
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //
    //                                              ADAPTER LISTENER
    //
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    private val mAdapterListener: StargazersAdapter.StargazersAdapterListener = object: StargazersAdapter.StargazersAdapterListener{
        override fun onBottomReached(position: Int) {
            mPresenter.loadStargazersList()
        }
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //
    //                                                  VIEW
    //
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    override fun loadData(data: List<Stargazer>) {
        Log.d(TAG, data.toString())
        adapter.setData(data)
    }

    override fun rootListError() {
        Toast.makeText(activity, "ERRORE!", Toast.LENGTH_SHORT).show()
    }
}