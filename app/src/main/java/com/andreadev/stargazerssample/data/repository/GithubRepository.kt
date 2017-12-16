package com.andreadev.stargazerssample.data.repository

import com.andreadev.stargazerssample.data.interactor.GithubApiInteractor
import com.andreadev.stargazerssample.data.models.Stargazer
import com.andreadev.stargazerssample.data.models.StargazerRequest
import io.reactivex.Observable
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class GithubRepository{

    private var githubApiInteractor: GithubApiInteractor

    private var stargazersData : ArrayList<Stargazer> = ArrayList()
    private var repoData : StargazerRequest? = null

    @Inject constructor(interactor: GithubApiInteractor){
        githubApiInteractor = interactor
    }

    fun stargazers(req: StargazerRequest?, page: Int, forceRefresh: Boolean): Observable<Pair<Boolean, List<Stargazer>>> {

        if(forceRefresh){
            repoData = req
            stargazersData = ArrayList()
        }

        return githubApiInteractor.stargazers(repoData, page)
                .flatMap{ response ->
                    stargazersData.addAll(response)

                    var isLastPage = response.isEmpty()
                    return@flatMap Observable.just(Pair(isLastPage, stargazersData))
                }
    }


    fun getCachedStargazers(): Observable<List<Stargazer>> {
        return Observable.just(stargazersData)
    }

}
