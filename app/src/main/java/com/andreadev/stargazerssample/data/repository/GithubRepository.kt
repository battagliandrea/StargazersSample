package com.andreadev.stargazerssample.data.repository

import com.andreadev.stargazerssample.data.interactor.GithubApiInteractor
import com.andreadev.stargazerssample.data.models.Stargazer
import io.reactivex.Observable
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class GithubRepository{

    private var githubApiInteractor: GithubApiInteractor

    private var mCurrentPage: Int = 0
    private var isLastPage: Boolean = false
    private var stargazersData : ArrayList<Stargazer>

    @Inject constructor(interactor: GithubApiInteractor){
        githubApiInteractor = interactor
        stargazersData = ArrayList()
    }

    fun stargazers(): Observable<List<Stargazer>> {
        if(stargazersData.isEmpty()){
            mCurrentPage += 1
            return githubApiInteractor.stargazers(1)
                    .flatMap{ response ->
                        stargazersData.addAll(response)
                        isLastPage = response.isEmpty()
                        return@flatMap Observable.just(stargazersData)
                    }
        } else {
            return Observable.just(stargazersData)
        }
    }

}
