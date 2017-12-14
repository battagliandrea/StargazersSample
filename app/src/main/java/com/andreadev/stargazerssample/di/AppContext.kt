package com.andreadev.stargazerssample.di

import java.lang.annotation.Retention
import java.lang.annotation.RetentionPolicy
import javax.inject.Qualifier

/**
 * Created by andrea on 26/08/2017.
 */

@Qualifier
@Retention(RetentionPolicy.RUNTIME)
annotation class AppContext