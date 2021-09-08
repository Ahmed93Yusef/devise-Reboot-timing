package com.example.receiving_broadcasts.util

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.widget.Toast


class MyBroadcastReceiver : BroadcastReceiver() {
    private var number: Int = 0
    override fun onReceive(p0: Context?, p1: Intent?) {

        when (p1?.action) {
            Intent.ACTION_SHUTDOWN -> {
                number = if (p1.extras?.getBoolean(Constant.STATE) == true) {
                    1
                } else {
                    2
                }
            }
        }
    }
    fun isTrue(): Boolean {
        return number == 2
    }

}