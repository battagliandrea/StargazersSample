package com.andreadev.stargazerssample.ui.utils

import android.app.Activity
import android.support.design.widget.Snackbar
import android.support.v4.app.ActivityCompat
import com.andreadev.stargazerssample.R
import com.andreadev.stargazerssample.exceptions.GitHubApiException
import com.andreadev.stargazerssample.exceptions.NetworkException

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

        fun showError(activity: Activity, throwable: Throwable) {
            var res = R.string.error_undefined
            if (throwable is NetworkException) {
                res = getErrorString(throwable)
            } else if (throwable is GitHubApiException) {
                res = getErrorString(throwable)
            }
            showError(activity, activity.getString(res))
        }

        private fun getErrorString(throwable: NetworkException): Int {
            when (throwable.type) {
                NetworkException.Type.NO_NETWORK -> return R.string.error_network_no_network
                NetworkException.Type.TIMEOUT -> return R.string.error_network_server_timeout
                else -> return R.string.error_network_undefined
            }
        }

        private fun getErrorString(throwable: GitHubApiException): Int {
            when (throwable.code) {
                400 -> return R.string.error_api_400
                401 -> return R.string.error_api_401
                403 -> return R.string.error_api_403
                404 -> return R.string.error_api_404
                406 -> return R.string.error_api_406
                500 -> return R.string.error_api_500
                else -> return R.string.error_undefined
            }
        }

    }

}