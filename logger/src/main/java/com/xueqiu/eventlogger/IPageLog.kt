package com.xueqiu.eventlogger

interface IPageLog {

    fun getPageName() : String? = javaClass.simpleName

    fun getPageSource(): String

}