package com.andreadev.stargazerssample.api

import com.andreadev.stargazerssample.data.models.Stargazer
import io.reactivex.Observable
import retrofit2.adapter.rxjava2.Result
import retrofit2.http.GET

/**
 * Created by andrea on 23/04/17.
 */

interface GithubApi {

    @GET("repos/phalt/swapi/stargazers")
    fun stargazers(): Observable<Result<List<Stargazer>>>
}


