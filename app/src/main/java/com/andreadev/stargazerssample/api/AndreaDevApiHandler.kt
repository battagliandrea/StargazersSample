package com.andreadev.stargazerssample.api

import com.andreadev.stargazerssample.data.models.RootList
import io.reactivex.Observable
import javax.inject.Inject

/**
 * Created by andrea on 28/08/2017.
 */
class AndreaDevApiHandler @Inject constructor(api: AndreaDevApi) {

    private var mAndreaDevApi: AndreaDevApi = api

    //TODO: add compose to handle Retrofit's Result
    fun testJson(): Observable<RootList> {
        return mAndreaDevApi.testjson()
                .flatMap({result -> Observable.just(result.response()?.body())})
    }
}