package com.andreadev.stargazerssample.ui.utils

import android.app.Activity
import android.support.design.widget.Snackbar
import android.support.v4.app.ActivityCompat
import com.andreadev.stargazerssample.R

/**
 * Created by andrea on 16/12/2017.
 */
class UiUtils {

    companion object {

        fun showError(activity: Activity, errorMessage: String) {
            val snackbar = Snackbar.make(
                    activity.findViewById(R.id.frame_container),
                    errorMessage,
                    Snackbar.LENGTH_LONG
            )
            val snackbarView = snackbar.view
            snackbarView.setBackgroundColor(ActivityCompat.getColor(activity, R.color.red))
            snackbar.show()
        }

        /*fun showError(activity: Activity, throwable: Throwable) {
            var res = R.string.error_undefined
            if (throwable is NetworkException) {
                res = getErrorString(throwable)
            } else if (throwable is ApiException) {
                res = getErrorString(throwable)
            }
            showError(activity, activity.getString(res))
        }*/

    }

}