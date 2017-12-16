package com.andreadev.stargazerssample.api

import com.andreadev.stargazerssample.exceptions.GitHubApiException
import com.andreadev.stargazerssample.exceptions.NetworkException
import io.reactivex.Observable
import io.reactivex.ObservableTransformer
import retrofit2.HttpException
import java.net.SocketTimeoutException
import java.net.UnknownHostException

abstract class RetrofitRequestHanlder(apiInterface: GithubApi) {

    /**
     *  Launch specific Exception for all Api Error
     */
    private var mApiInterface: GithubApi = apiInterface


    fun <T> handleError(observable: Observable<T>) : ObservableTransformer<T, T> {
        return ObservableTransformer { upstream ->
            upstream.onErrorResumeNext(
                    { t: Throwable ->
                            if (t is HttpException) {

                                var errorBodyString = ""

                                val errorBody = t.response().errorBody()
                                if (errorBody != null) {
                                    errorBodyString = errorBody.string()
                                }

                                return@onErrorResumeNext Observable.error(GitHubApiException.Companion.create(t.message(), t, t.code(), errorBodyString))
                            }

                            if (t is java.net.ConnectException || t is UnknownHostException) {
                                return@onErrorResumeNext Observable.error(NetworkException.noNetwork(t))
                            }

                            if (t is SocketTimeoutException) {
                                return@onErrorResumeNext Observable.error(NetworkException.timeout(t))
                            }

                            return@onErrorResumeNext Observable.error(NetworkException.Companion.generic(t))
                    })
        }

    }
}