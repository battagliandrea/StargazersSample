package com.andreadev.stargazerssample.data.interactor

import com.andreadev.stargazerssample.api.GithubApi
import com.andreadev.stargazerssample.api.RetrofitRequestHanlder
import com.andreadev.stargazerssample.data.models.Stargazer
import com.andreadev.stargazerssample.data.models.StargazerRequest
import io.reactivex.Observable
import javax.inject.Inject

/**
 * Created by andrea on 28/08/2017.
 */
class GithubApiInteractor @Inject constructor(api: GithubApi): RetrofitRequestHanlder(api) {

    private var mGithubApi: GithubApi = api

    fun stargazers(req: StargazerRequest?, page: Int): Observable<List<Stargazer>> {
        val observable :  Observable<List<Stargazer>> = Observable.defer { mGithubApi.stargazers(req?.owner, req?.repo, page) }
        return observable.compose(handleError(observable))
    }

}