package com.andreadev.stargazerssample.ui.base

import android.content.res.Configuration
import android.os.Bundle
import android.os.PersistableBundle
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.widget.Toast
import com.andreadev.stargazerssample.R
import com.andreadev.stargazerssample.ui.widget.ProgressFragment
import com.evernote.android.state.State
import com.evernote.android.state.StateSaver

/**
 * Created by andrea on 16/08/2017.
 */
open class BaseActivity : AppCompatActivity() {

    private val FRAGMENT_TAG : String = "ROOT FRAGMENT"

    private lateinit var mFragment: Fragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        StateSaver.restoreInstanceState(this, savedInstanceState);
    }

    override fun onSaveInstanceState(outState: Bundle?) {
        super.onSaveInstanceState(outState)
        StateSaver.saveInstanceState(this, outState!!)
    }

    fun replaceFragment(savedInstanceState: Bundle?, fragment: Fragment){
        mFragment = fragment
        if(savedInstanceState == null){
            supportFragmentManager.beginTransaction().replace(R.id.frame_container, fragment, FRAGMENT_TAG).commit()
        } else {
            mFragment = supportFragmentManager.findFragmentByTag(FRAGMENT_TAG)
        }
    }

    fun showLoading(){
        supportFragmentManager.beginTransaction().add(R.id.frame_container, ProgressFragment(), "progress_fragment").commit()
    }

    fun hideLoading(){
        supportFragmentManager.beginTransaction().remove(supportFragmentManager.findFragmentByTag("progress_fragment")).commit()
    }
}
