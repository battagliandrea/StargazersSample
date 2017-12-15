package com.andreadev.stargazerssample.data.repository

import com.andreadev.stargazerssample.data.interactor.GithubApiInteractor
import com.andreadev.stargazerssample.data.models.Stargazer
import io.reactivex.Observable
import javax.inject.Inject

class GithubRepository @Inject constructor(interactor: GithubApiInteractor){

    private var githubApiInteractor: GithubApiInteractor = interactor

    private var stargazersData : ArrayList<Stargazer> = ArrayList()

    fun stargazers(page: Int): Observable<Pair<Boolean, List<Stargazer>>  > {
        return githubApiInteractor.stargazers(page)
                .flatMap{ response ->
                            stargazersData.addAll(response)
                            var lastPage = response.size == 0
                            return@flatMap Observable.just(Pair(lastPage, stargazersData))
                }
    }

}
