package com.andreadev.stargazerssample.ui.repolist

import com.andreadev.stargazerssample.data.models.Stargazer
import com.andreadev.stargazerssample.data.models.StargazerRequest
import com.andreadev.stargazerssample.data.repository.GithubRepository
import com.andreadev.stargazerssample.ui.base.BaseMvpPresenter
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

/**
 * Created by andrea on 16/08/2017.
 */
class StargazersPresenter(val githubRepository: GithubRepository) : BaseMvpPresenter<StargazersView>() {

    private val TAG = StargazersPresenter::class.java.simpleName

    private var mCurrentPage: Int = 1
    private var isLastPage: Boolean = false

    fun startSearch(owner: String, repo: String){
        mCurrentPage = 1
        isLastPage = false
        if(!owner.isNullOrEmpty() || !repo.isNullOrEmpty()){
            loadStargazers(githubRepository.stargazers(StargazerRequest(owner, repo), mCurrentPage, true))
        } else {
            getView()?.validationError()
        }

    }

    fun loadMore(){
        if(!isLastPage){
            mCurrentPage += 1
            loadStargazers(githubRepository.stargazers(null, mCurrentPage, false))
        }
    }

    private fun loadStargazers(observable: Observable<Pair<Boolean, ArrayList<Stargazer>>>) {
        mView?.showLoading()
        observable
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnNext { pair ->
                    isLastPage = pair.first
                    getView()?.loadData(pair.second)
                }
                .subscribe(
                        { pair ->
                            mView?.hideLoading()
                        },
                        { error ->
                            error.printStackTrace()
                            getView()?.rootListError(error)
                            mView?.hideLoading()
                        })
    }

    fun resumeData(){
        mView?.showLoading()
        githubRepository.getCachedStargazers()
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        { data ->
                            getView()?.loadData(data)
                            mView?.hideLoading()
                        },
                        { error ->
                            error.printStackTrace()
                            getView()?.rootListError(error)
                            mView?.hideLoading()
                        })
    }
}