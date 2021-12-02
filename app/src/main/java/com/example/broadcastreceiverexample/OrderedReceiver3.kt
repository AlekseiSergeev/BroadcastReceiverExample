package com.example.broadcastreceiverexample

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.widget.Toast

class OrderedReceiver3: BroadcastReceiver() {

    override fun onReceive(context: Context?, intent: Intent?) {
        var resultCode = resultCode
        var resultData = resultData
        val resultExtras = getResultExtras(true)
        var stringExtra = resultExtras.getString("keyString")

        resultCode++
        stringExtra += "-> OR3"

        val toastText =
            "OR3\n resultCode: $resultCode \n resultData: $resultData \n stringExtra: $stringExtra"

        Toast.makeText(context, toastText, Toast.LENGTH_LONG).show()

        resultData = "OR3"
        resultExtras.putString("keyString", stringExtra)

        setResult(resultCode, resultData, resultExtras)
    }
}