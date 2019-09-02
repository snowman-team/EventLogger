package com.xueqiu.eventlogger

import android.content.Context

object ELog {

    private var isDebug: Boolean = false
    private val mLogger: MutableList<BaseEventLogger> = ArrayList()

    fun init(context: Context, options: EventLogOptions) {
        isDebug = options.isDebug
        mLogger.clear()
        mLogger.addAll(options.eventLoggers)

        mLogger.forEach {
            it.initLogger(context, isDebug)
        }
    }

    fun log(context: Context, event: LogEvent) {
        mLogger.forEach {
            it.log(context, event)
        }
    }

    fun <T : BaseEventLogger> getLogger(loggerID: String): T? =
        mLogger.find { it.getLoggerID() == loggerID }?.let { it as T }
}