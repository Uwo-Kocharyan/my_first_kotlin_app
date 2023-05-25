package com.example.mykotlinapp

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.mykotlinapp.adapter.PokemonAdapter
import com.example.mykotlinapp.databinding.ActivityMainBinding
import com.example.mykotlinapp.network.PokemonAPIService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch


class MainActivity : AppCompatActivity() {

    //  var mTextViewResult: RecyclerView? = null
    private lateinit var binding: ActivityMainBinding
    var pokAPI = PokemonAPIService()


    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        val adapter1 = PokemonAdapter()
        binding.recyclerView.adapter = adapter1
        GlobalScope.launch(Dispatchers.IO) {
            pokAPI.requestPokApi(
                onResponse = {
                    runOnUiThread {
                        adapter1.array = it
                        adapter1.notifyDataSetChanged()
                    }

                }
            )
        }
        Log.d(tAG, "Activity created")
    }

    private var tAG = "lifecycle"


//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        binding = ActivityMainBinding.inflate(layoutInflater)
//        setContentView(binding.root)
//        binding.recyclerView.layoutManager = LinearLayoutManager(this)
//        val adapter = UserAdapter().apply {
//            data = listOf(
//                Users("name1"),
//                Users("name2"),
//                Users("name3"),
//                Users("name4"),
//                Users("name5"),
//                Users("name6"),
//                Users("name7"),
//                Users("name8"),
//                Users("name9"),
//            )
//            notifyDataSetChanged()
//        }

//        binding.recyclerView.adapter = adapter
//        Log.d(tAG, "Activity created")
//    }

    override fun onStart() {
        super.onStart()
        Log.d(tAG, "Activity started")
    }

    override fun onResume() {
        super.onResume()
        Log.d(tAG, "Activity focused")
    }

    override fun onPause() {
        super.onPause()
        Log.d(tAG, "Activity paused")
    }

    override fun onStop() {
        super.onStop()
        Log.d(tAG, "Activity stoped")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(tAG, "Activity killed")
    }


}