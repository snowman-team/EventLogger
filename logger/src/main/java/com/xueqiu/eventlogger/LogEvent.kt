package com.xueqiu.eventlogger

open class LogEvent(@JvmField val category: String,
                    @JvmField val target: String,
                    @JvmField val action: String,
                    @JvmField val page: String,
                    @JvmField val source: String) {

    companion object {
        const val EVENT_KEY_CATEGORY = "category"
        const val EVENT_KEY_TARGET = "target"
        const val EVENT_KEY_ACTION = "action"
        const val EVENT_KEY_PAGE = "page"
        const val EVENT_KEY_SOURCE = "source"
        const val EVENT_KEY_TIMESTAMP = "timestamp"
        const val EVENT_KEY_EXTRA = "extra"
    }

    @JvmField
    var timestamp: Long = System.currentTimeMillis()

    @JvmField
    var extra: Map<String, Any>? = null

}