package com.xueqiu.eventlogger

class EventLogOptions {

    var eventLoggers: MutableList<BaseEventLogger> = ArrayList()
        private set

    var isDebug: Boolean = true
        private set

    fun withLogger(eventLogger: BaseEventLogger): EventLogOptions {
        var hasItem = false
        eventLoggers.forEach {
            if (it.getLoggerID() == eventLogger.getLoggerID()) {
                hasItem = true
                return@forEach
            }
        }
        if (!hasItem) {
            eventLoggers.add(eventLogger)
        }
        return this
    }

    fun isDebug(boolean: Boolean): EventLogOptions {
        isDebug = boolean
        return this
    }
}