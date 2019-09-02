package com.xueqiu.eventlogger

import android.content.Context

abstract class BaseEventLogger {

    abstract fun getLoggerID(): String

    abstract fun initLogger(context: Context, isDebug: Boolean)

    abstract fun log(context: Context, event: LogEvent)

    abstract fun setUser(uid: String)

    abstract fun removeUser(uid: String)

}