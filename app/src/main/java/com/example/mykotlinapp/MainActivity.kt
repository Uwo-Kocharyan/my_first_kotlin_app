package com.example.mykotlinapp

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mykotlinapp.adapter.PokemonAdapter
import com.example.mykotlinapp.databinding.ActivityMainBinding
import com.example.mykotlinapp.model.Pokemon


class MainActivity : AppCompatActivity() {
    var TAG ="lifecycle"

    private lateinit var binding: ActivityMainBinding
    private lateinit var adapter: PokemonAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        val adapter = PokemonAdapter().apply {
            data = listOf(
                Pokemon("name1"),
                Pokemon("name2"),
                Pokemon("name3"),
                Pokemon("name4"),
                Pokemon("name5"),
                Pokemon("name6"),
                Pokemon("name7"),
                Pokemon("name8"),
                Pokemon("name9"),
            )
            notifyDataSetChanged()
        }
        binding.recyclerView.adapter = adapter
        Log.d(TAG,"Activity created")
    }

    override fun onStart() {
        super.onStart()
        Log.d(TAG,"Activity started")
    }

    override fun onResume() {
        super.onResume()
        Log.d(TAG,"Activity focused")
    }

    override fun onPause() {
        super.onPause()
        Log.d(TAG,"Activity paused")
    }

    override fun onStop() {
        super.onStop()
        Log.d(TAG,"Activity stoped")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG,"Activity killed")
    }


}