package com.andreadev.stargazerssample.api

import com.andreadev.stargazerssample.data.models.RootList
import io.reactivex.Observable
import retrofit2.adapter.rxjava2.Result
import retrofit2.http.GET

/**
 * Created by andrea on 23/04/17.
 */

interface AndreaDevApi {

    @GET("api")
    fun testjson(): Observable<Result<RootList>>
}


