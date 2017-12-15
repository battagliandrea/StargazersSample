package com.andreadev.stargazerssample.data.interactor

import com.andreadev.stargazerssample.api.GithubApi
import com.andreadev.stargazerssample.data.models.Stargazer
import io.reactivex.Observable
import javax.inject.Inject

/**
 * Created by andrea on 28/08/2017.
 */
class GithubApiInteractor @Inject constructor(api: GithubApi) {

    private var mGithubApi: GithubApi = api

    //TODO: add compose to handle Retrofit's Result
    fun stargazers(page: Int): Observable<List<Stargazer>> {
        return mGithubApi.stargazers(page)
                .flatMap({result -> Observable.just(result.response()?.body())})
    }
}