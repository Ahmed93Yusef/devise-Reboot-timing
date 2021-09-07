package com.example.receiving_broadcasts

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class ArticleDbHelper(context: Context): SQLiteOpenHelper(context,Constant.DBNAME,null,Constant.DBVERSION) {
    override fun onCreate(p0: SQLiteDatabase?) {
        val sql = "CREATE TABLE ${Constant.TABLE_NAME}("+
                "${Constant.ID} INTEGER PRIMARY KEY," +
                "${Constant.TIME} TEXT)"
        p0?.execSQL(sql)
    }

    override fun onUpgrade(p0: SQLiteDatabase?, p1: Int, p2: Int) {
    }
}