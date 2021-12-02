package com.example.broadcastreceiverexample

import android.Manifest
import android.content.IntentFilter
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {

    lateinit var orderedReceiver1: OrderedReceiver1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        orderedReceiver1 = OrderedReceiver1()

        val filter = IntentFilter("com.example.EXAMPLE_ACTION")
        filter.priority = 1

        registerReceiver(orderedReceiver1, filter, Manifest.permission.VIBRATE, null)
    }

    override fun onDestroy() {
        super.onDestroy()
        unregisterReceiver(orderedReceiver1)
    }
}