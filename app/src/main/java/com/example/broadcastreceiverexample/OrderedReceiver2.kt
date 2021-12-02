package com.example.broadcastreceiverexample

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.os.Handler
import android.os.SystemClock
import android.widget.Toast

class OrderedReceiver2: BroadcastReceiver() {

    override fun onReceive(context: Context?, intent: Intent?) {
        val handler = Handler()

        val pendingResult = goAsync()

        Thread(object : Runnable {
            override fun run() {

                SystemClock.sleep(10 * 1000)

                var resultCode = pendingResult.resultCode
                var resultData = pendingResult.resultData
                val resultExtras = pendingResult.getResultExtras(true)
                var stringExtra = resultExtras.getString("keyString")

                resultCode++
                stringExtra += "-> OR2"

                val toastText =
                    "OR2 \n resultCode: $resultCode \n resultData: $resultData \n stringExtra: $stringExtra"

                handler.post(object : Runnable {
                    override fun run() {
                        Toast.makeText(context, toastText, Toast.LENGTH_LONG).show()
                    }
                })

                resultData = "OR2"
                resultExtras.putString("keyString", stringExtra)

                pendingResult.setResult(resultCode, resultData, resultExtras)
                pendingResult.finish()
            }
        }).start()
    }
}