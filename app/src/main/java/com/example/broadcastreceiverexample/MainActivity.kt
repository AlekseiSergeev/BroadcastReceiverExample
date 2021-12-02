package com.example.broadcastreceiverexample

import android.content.IntentFilter
import android.net.ConnectivityManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {

    lateinit var exampleBroadcastReceiver: ExampleBroadcastReceiver

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        exampleBroadcastReceiver = ExampleBroadcastReceiver()

        val exampleFilter = IntentFilter("com.example.EXAMPLE_ACTION")
        exampleFilter.addAction(ConnectivityManager.CONNECTIVITY_ACTION)

        registerReceiver(exampleBroadcastReceiver, exampleFilter)
    }

    override fun onDestroy() {
        super.onDestroy()
        unregisterReceiver(exampleBroadcastReceiver)
    }
}