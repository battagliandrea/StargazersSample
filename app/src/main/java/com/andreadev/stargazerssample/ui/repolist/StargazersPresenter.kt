package com.andreadev.stargazerssample.ui.repolist

import com.andreadev.stargazerssample.data.models.Stargazer
import com.andreadev.stargazerssample.data.repository.GithubRepository
import com.andreadev.stargazerssample.ui.base.BaseMvpPresenter
import com.bumptech.glide.Glide.init
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

/**
 * Created by andrea on 16/08/2017.
 */
class StargazersPresenter(val githubRepository: GithubRepository) : BaseMvpPresenter<StargazersView>() {

    private val TAG = StargazersPresenter::class.java.simpleName

    fun resumeData() {
        mView?.showLoading()
        Observable.just(githubRepository.stargazers()
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        { data ->
                            getView()?.loadData(data)
                            mView?.hideLoading()
                        },
                        { error ->
                            error.printStackTrace()
                            getView()?.rootListError()
                            mView?.hideLoading()
                        })
        )


    }

    fun loadMore(){

    }
}