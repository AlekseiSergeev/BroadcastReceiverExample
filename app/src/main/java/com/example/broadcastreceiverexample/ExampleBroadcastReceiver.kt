package com.example.broadcastreceiverexample

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.net.ConnectivityManager
import android.widget.Toast

class ExampleBroadcastReceiver: BroadcastReceiver() {

    override fun onReceive(context: Context?, intent: Intent?) {

        if(Intent.ACTION_BOOT_COMPLETED.equals(intent?.action)) {
            Toast.makeText(context, "Boot completed", Toast.LENGTH_SHORT).show()
        }

        if(ConnectivityManager.CONNECTIVITY_ACTION.equals(intent?.action)) {
           val noConnectivity = intent?.getBooleanExtra(
               ConnectivityManager.EXTRA_NO_CONNECTIVITY, false)
            if(noConnectivity == true) {
                Toast.makeText(context, "Disconnected", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(context, "Connected", Toast.LENGTH_SHORT).show()
            }
        }

        if("com.example.EXAMPLE_ACTION".equals(intent?.action)) {
            val receivedText = intent?.getStringExtra("com.example.EXTRA_TEXT")
            Toast.makeText(context, receivedText ?: "empty message!" , Toast.LENGTH_SHORT).show()
        }
    }
}