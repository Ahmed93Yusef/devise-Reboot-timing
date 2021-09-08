package com.example.receiving_broadcasts.data

object DataManger {
    private val dateList = mutableListOf<String>()
    val date: List<String>
    get() = dateList
    fun addDate(date: String) = dateList.add(date)

}