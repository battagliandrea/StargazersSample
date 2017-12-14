package com.andreadev.stargazerssample.ui.widget

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.andreadev.stargazerssample.R

/**
 * Created by andrea on 19/09/17.
 */
class ProgressFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater!!.inflate(R.layout.fragment_progress, container, false)
    }
}