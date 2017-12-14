package com.andreadev.kotlinmvp.data.repository

import com.andreadev.kotlinmvp.api.AndreaDevApiHandler
import com.andreadev.kotlinmvp.data.models.RootList
import io.reactivex.Observable
import javax.inject.Inject

class RootRepository @Inject constructor(handler: AndreaDevApiHandler){

    private var andreaDevApiHandler : AndreaDevApiHandler = handler

    fun rootList(): Observable<RootList> {
        return andreaDevApiHandler.testJson()
                .flatMap{ response -> Observable.just(response) }
    }

}
