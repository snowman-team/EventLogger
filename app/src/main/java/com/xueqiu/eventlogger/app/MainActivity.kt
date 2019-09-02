package com.xueqiu.eventlogger.app

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.xueqiu.eventlogger.ELog
import com.xueqiu.eventlogger.LogEvent

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val event = LogEvent(category = "example",
                action = "page_show",
                target = "main",
                page = "main",
                source = "none")
        ELog.log(this, event)
    }
}
