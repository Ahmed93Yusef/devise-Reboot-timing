package com.example.receiving_broadcasts

import android.content.BroadcastReceiver
import android.content.ContentValues
import android.content.Context
import android.content.Intent
import android.widget.Toast
import java.util.*


class MyBroadcastReceiver : BroadcastReceiver() {
    private var number: Int = 0
    override fun onReceive(p0: Context?, p1: Intent?) {
        when (p1?.action) {
            Intent.ACTION_SHUTDOWN -> {
                number = if (p1.extras?.getBoolean(Constant.STATE) == true) {
                    Toast.makeText(p0, "hello There", Toast.LENGTH_SHORT).show()
                    1
                } else {
                    Toast.makeText(p0, "No Action", Toast.LENGTH_SHORT).show()
                    2
                }
            }
        }

    }
    fun isTrue(): Boolean {
        return number == 2
    }

}