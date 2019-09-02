package com.xueqiu.eventlogger.umeng

import android.content.Context
import com.umeng.analytics.MobclickAgent
import com.umeng.commonsdk.UMConfigure
import com.xueqiu.eventlogger.BaseEventLogger
import com.xueqiu.eventlogger.LogEvent

class UmengEventLogger(val appKey: String, val channel: String) : BaseEventLogger() {

    companion object {
        const val LOGGER_ID_UMENG = "umeng"
    }

    override fun getLoggerID(): String = LOGGER_ID_UMENG

    override fun initLogger(context: Context, isDebug: Boolean) {
        UMConfigure.init(context, appKey, channel, UMConfigure.DEVICE_TYPE_PHONE, null)
        UMConfigure.setLogEnabled(isDebug)
    }

    override fun log(context: Context, event: LogEvent) {
        val map = HashMap<String, Any>()
        map[LogEvent.EVENT_KEY_TARGET] = event.target
        map[LogEvent.EVENT_KEY_ACTION] = event.action
        map[LogEvent.EVENT_KEY_PAGE] = event.page
        map[LogEvent.EVENT_KEY_SOURCE] = event.source
        map[LogEvent.EVENT_KEY_TIMESTAMP] = event.timestamp
        event.extra?.let {
            map.putAll(it)
        }
        MobclickAgent.onEventObject(context, event.category, map)
    }

    override fun setUser(uid: String) {
        MobclickAgent.onProfileSignIn(uid)
    }

    override fun removeUser(uid: String) {
        MobclickAgent.onProfileSignOff()
    }

    fun setSessionTrackMode(mode: MobclickAgent.PageMode) {
        MobclickAgent.setPageCollectionMode(mode)
    }

}