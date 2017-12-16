package com.andreadev.stargazerssample.data.repository

import com.andreadev.stargazerssample.data.interactor.GithubApiInteractor
import com.andreadev.stargazerssample.data.models.Stargazer
import io.reactivex.Observable
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class GithubRepository{

    private var githubApiInteractor: GithubApiInteractor

    private var mCurrentPage: Int = 1
    private var isLastPage: Boolean = false
    private var stargazersData : ArrayList<Stargazer>

    @Inject constructor(interactor: GithubApiInteractor){
        githubApiInteractor = interactor
        stargazersData = ArrayList()
    }

    fun stargazers(loadMore: Boolean, forceRefresh: Boolean): Observable<List<Stargazer>> {

        if(!loadMore && !forceRefresh){
            return Observable.just(stargazersData)
        } else if(loadMore){
            mCurrentPage += 1
        } else {
            mCurrentPage = 1
            isLastPage = false
        }

        return githubApiInteractor.stargazers(mCurrentPage)
                .flatMap{ response ->
                    stargazersData.addAll(response)
                    isLastPage = response.isEmpty()
                    return@flatMap Observable.just(stargazersData)
                }
    }

}
