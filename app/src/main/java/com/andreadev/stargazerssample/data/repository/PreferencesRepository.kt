package com.andreadev.stargazerssample.data.repository

import android.content.SharedPreferences

import javax.inject.Inject
import javax.inject.Singleton

/**
 * Created by andrea on 23/04/17.
 */

@Singleton
class PreferencesRepository @Inject constructor(sp: SharedPreferences) {

    private var mSharedPreferences : SharedPreferences = sp

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //
    //                                                  STRING
    //
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    fun put(key: String, value: String) {
        mSharedPreferences.edit().putString(key, value).apply()
    }

    fun get(key: String, defaultValue: String): String? {
        return mSharedPreferences.getString(key, defaultValue)
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //
    //                                                  INTEGER
    //
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    fun put(key: String, value: Int) {
        mSharedPreferences.edit().putInt(key, value).apply()
    }

    fun get(key: String, defaultValue: Int): Int? {
        return mSharedPreferences.getInt(key, defaultValue)
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //
    //                                                  FLOAT
    //
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    fun put(key: String, value: Float) {
        mSharedPreferences.edit().putFloat(key, value).apply()
    }

    fun get(key: String, defaultValue: Float): Float? {
        return mSharedPreferences.getFloat(key, defaultValue)
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //
    //                                                  BOOLEAN
    //
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    fun put(key: String, value: Boolean) {
        mSharedPreferences.edit().putBoolean(key, value).apply()
    }

    fun get(key: String, defaultValue: Boolean): Boolean? {
        return mSharedPreferences.getBoolean(key, defaultValue)
    }

    fun deleteSavedData(key: String) {
        mSharedPreferences.edit().remove(key).apply()
    }

}