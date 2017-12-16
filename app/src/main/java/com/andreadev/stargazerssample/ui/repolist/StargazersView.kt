package com.andreadev.stargazerssample.ui.repolist

import com.andreadev.stargazerssample.data.models.Stargazer
import com.andreadev.stargazerssample.ui.base.BaseMvpView

/**
 * Created by andrea on 18/08/2017.
 */
interface StargazersView : BaseMvpView {

    fun loadData(data : List<Stargazer>)
    fun rootListError()

    fun validationError()
}