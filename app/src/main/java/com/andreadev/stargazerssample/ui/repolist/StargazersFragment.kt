package com.andreadev.stargazerssample.ui.repolist

import android.os.Bundle
import android.os.Parcelable
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.andreadev.stargazerssample.App
import com.andreadev.stargazerssample.R
import com.andreadev.stargazerssample.R.id.*
import com.andreadev.stargazerssample.data.models.Stargazer
import com.andreadev.stargazerssample.di.components.DaggerFragmentComponent
import com.andreadev.stargazerssample.ui.base.BaseMvpFragment
import com.evernote.android.state.State
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
    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    @Inject
    lateinit var stargazersPresenter: StargazersPresenter

    companion object Instance{
        fun newIstance(): StargazersFragment = StargazersFragment()
    }

    init {
        DaggerFragmentComponent.builder().appComponent(App.component).build().inject(this)
    }

    override fun instancePresenter(): StargazersPresenter = stargazersPresenter


    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //
    //                                                  FRAGMENT
    //
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    private lateinit var adapter : StargazersAdapter

    @State
    var mListState: Parcelable? = null

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater!!.inflate(R.layout.fragment_stargazers, container, false)
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        adapter = StargazersAdapter(activity, mAdapterListener)
        rv.layoutManager = LinearLayoutManager(activity)
        rv.adapter = adapter

        setupListener()

        mPresenter.resumeData()
    }

    override fun onSaveInstanceState(outState: Bundle?) {
        mListState = rv.layoutManager.onSaveInstanceState()
        super.onSaveInstanceState(outState)
    }

    private fun restoreListState(){
        if(mListState!=null){
            rv.layoutManager.onRestoreInstanceState(mListState)
            mListState=null
        }
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //
    //                                              LISTENER
    //
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    private fun setupListener(){
        send_btn.setOnClickListener({
            mPresenter.startSearch(
                    et_owner.text.toString(),
                    et_repo.text.toString()
            )
        })
    }


    private val mAdapterListener: StargazersAdapter.StargazersAdapterListener = object: StargazersAdapter.StargazersAdapterListener{
        override fun onBottomReached(position: Int) {
            mPresenter.loadMore()
        }
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //
    //                                                  VIEW
    //
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    override fun loadData(data: List<Stargazer>) {
        adapter.setData(data)
        restoreListState()
    }

    override fun rootListError(throwable: Throwable) {
        showError(throwable)
    }

    override fun validationError() {
        showError(activity.getString(R.string.validation_error))
    }
}