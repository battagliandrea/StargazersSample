package com.andreadev.stargazerssample.route

import android.support.v4.app.Fragment
import com.andreadev.stargazerssample.ui.home.HomeActivity

/**
 * Created by andrea on 18/08/2017.
 */
class RouteManager {

    companion object Instance{

        fun home(fragment: Fragment) {
            val intent = HomeActivity.getIntent(fragment.activity)
            fragment.startActivity(intent)
        }

    }
}