package com.example.mykotlinapp

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val arrayAdapter: ArrayAdapter<*>
        val users = arrayOf(
            "User 1", "User 2", "User 3",
            "User 4", "User 5"
        )
        val mListView = findViewById<ListView>(R.id.userList)
        arrayAdapter = ArrayAdapter(
            this,
            android.R.layout.simple_list_item_1, users
        )
        mListView.adapter = arrayAdapter
    }
}