package com.andreadev.stargazerssample.api

import com.andreadev.stargazerssample.data.models.Stargazer
import io.reactivex.Observable
import retrofit2.adapter.rxjava2.Result
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

/**
 * Created by andrea on 23/04/17.
 */

interface GithubApi {

    @GET("repos/{owner}/{repo}/stargazers")
    fun stargazers(
            @Path("owner") owner: String?,
            @Path("repo") repo: String?,
            @Query("page") page: Int): Observable<Result<List<Stargazer>>>
}


