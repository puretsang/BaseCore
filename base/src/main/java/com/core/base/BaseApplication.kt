package com.core.base

import android.app.Application

/**
 * Created by waikeytsang on 2017/12/9.
 */
class BaseApplication :Application() {

    override fun onCreate() {
        super.onCreate()
        instance = this
    }

    companion object {
        var instance: BaseApplication? = null
        fun instance() = instance!!
    }
}