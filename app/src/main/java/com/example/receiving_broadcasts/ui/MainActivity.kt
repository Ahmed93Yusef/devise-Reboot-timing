package com.example.receiving_broadcasts.ui

import android.content.ContentValues
import android.content.Intent
import android.content.IntentFilter
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.database.getStringOrNull
import com.example.receiving_broadcasts.data.ArticleDbHelper
import com.example.receiving_broadcasts.data.DataManger
import com.example.receiving_broadcasts.databinding.ActivityMainBinding
import com.example.receiving_broadcasts.util.Constant
import com.example.receiving_broadcasts.util.MyBroadcastReceiver
import java.util.*

class MainActivity : AppCompatActivity() {
    private val broadcastReceiver = MyBroadcastReceiver()
    private lateinit var  dataBaseHelper: ArticleDbHelper
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        dataBaseHelper = ArticleDbHelper(applicationContext)
        val filter = IntentFilter()
        filter.addAction(Intent.ACTION_SHUTDOWN)
        val adapter = ItemAdapter(DataManger.date)
        binding.recycleText.adapter = adapter
        registerReceiver(broadcastReceiver,filter)
        readData()
    }
    override fun onPause() {
        super.onPause()
        writeData()
    }
    private fun writeData(){
        if (broadcastReceiver.isTrue()){
            val time = Calendar.getInstance().time
            val newEntry = ContentValues().apply {
            put(Constant.TIME, time.toString())
        }
        dataBaseHelper.writableDatabase.insert(Constant.TABLE_NAME,null, newEntry)
        }
    }
    private fun readData() {
        val cursor = dataBaseHelper.readableDatabase.rawQuery("SELECT * FROM ${Constant.TABLE_NAME}", arrayOf<String>())
        while (cursor.moveToNext()){
        val time = cursor.getStringOrNull(0)
            if (time != null) {
                DataManger.addDate(time.toString())
            }
        }
    }
}