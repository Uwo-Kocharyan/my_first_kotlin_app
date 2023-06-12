package com.example.mykotlinapp

import UserAdapter1
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.mvvm.viewModel.UseriewModel
import com.example.mykotlinapp.adapter.PokemonAdapter
import com.example.mykotlinapp.adapter.UserAdapter
import com.example.mykotlinapp.databinding.ActivityMainBinding
import com.example.mykotlinapp.network.PokemonAPIService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch


class MainActivity : AppCompatActivity() {

    //  var mTextViewResult: RecyclerView? = null
    private lateinit var binding: ActivityMainBinding
    var pokAPI = PokemonAPIService()

    // TODO:  create viewmodel
    var userVM : UseriewModel? =null

     val userViewModel : UseriewModel? =null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

//        -----------
        binding.updateBtn.setOnClickListener {
            userVM?.userList
        }
//        -----------

        binding.recyclerView.layoutManager = LinearLayoutManager(this)
//        val adapter1 = PokemonAdapter()
        val adapter1 = UserAdapter1()
        userViewModel?.getListUsers()?.observe(this, Observer {
            it?.let {
                adapter1.refreshUsers(it)
            }
        })
        // TODO: obsderve and update UI
         userVM?.userList?.observe(this){
             binding.updateBtn.setOnClickListener {
                 userVM?.updateListUsers()
             }


         }
        // UPDATE ADAPTER LIST
//
//    }
        binding.recyclerView.adapter = adapter1

//        GlobalScope.launch(Dispatchers.IO) {
//            pokAPI.requestPokApi(
//                onResponse = {
//                    runOnUiThread {
//                        adapter1.data = it
//                        adapter1.notifyDataSetChanged()
//                    }
//
//                }
//            )
//        }
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
}