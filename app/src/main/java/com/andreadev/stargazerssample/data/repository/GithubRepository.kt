package com.andreadev.stargazerssample.data.repository

import com.andreadev.stargazerssample.data.interactor.GithubApiInteractor
import com.andreadev.stargazerssample.data.models.Stargazer
import io.reactivex.Observable
import javax.inject.Inject

class GithubRepository @Inject constructor(interactor: GithubApiInteractor){

    private var githubApiInteractor: GithubApiInteractor = interactor

    fun stargazers(): Observable<List<Stargazer>> {
        return githubApiInteractor.stargazers()
                .flatMap{ response -> Observable.just(response) }
    }

}
