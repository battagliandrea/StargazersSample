package com.andreadev.stargazerssample.route

import android.support.v4.app.Fragment
import com.andreadev.stargazerssample.ui.repolist.StargazersActivity

/**
 * Created by andrea on 18/08/2017.
 */
class RouteManager {

    companion object Instance{

        fun repoList(fragment: Fragment) {
            val intent = StargazersActivity.getIntent(fragment.activity)
            fragment.startActivity(intent)
        }

    }
}