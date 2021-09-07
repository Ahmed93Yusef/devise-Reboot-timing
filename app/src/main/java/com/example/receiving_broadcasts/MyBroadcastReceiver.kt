package com.example.receiving_broadcasts

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.widget.Toast


class MyBroadcastReceiver : BroadcastReceiver() {
    private var number = 0
    private var count = 0
    override fun onReceive(p0: Context?, p1: Intent?) {
        if (Intent.ACTION_REBOOT == p1?.action){
            Toast.makeText(p0,"hello There",Toast.LENGTH_SHORT).show()
                   number = 1
                   count++
        }else{
            number = 2
        }
//        when(p1?.action){
//            Intent.ACTION_SHUTDOWN -> {
//               if (p1.extras?.getBoolean(Constant.STATE) == true){
//                   Toast.makeText(p0,"hello There",Toast.LENGTH_SHORT).show()
//                   number = 1
//                   count++
//               } else{
//                   number = 2
//               }
//            }
//        }

    }
    fun textConvert (): String {
        return if (number == 1){
            "The devise Shut Down $count"
        }else{
            "The devise Not Shut Down"
        }
    }


}