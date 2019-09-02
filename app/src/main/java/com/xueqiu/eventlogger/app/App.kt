package com.xueqiu.eventlogger.app

import android.app.Application
import com.xueqiu.butler.Butler
import com.xueqiu.eventlogger.ELog
import com.xueqiu.eventlogger.EventLogOptions
import com.xueqiu.eventlogger.umeng.UmengEventLogger

class App : Application() {

    override fun onCreate() {
        super.onCreate()

        Butler.init(this)

        val options = EventLogOptions()
            .isDebug(BuildConfig.DEBUG)
            .withLogger(UmengEventLogger("5d6cc5ed0cafb21a5b000f0e", "test"))
        ELog.init(this, options)
    }
}